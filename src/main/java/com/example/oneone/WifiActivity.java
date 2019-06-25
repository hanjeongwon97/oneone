package com.example.oneone;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class WifiActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    MapFragment mapFrag;
    GroundOverlayOptions Mark;
    String tag = "wifi";
    Button button;
    ArrayList<WiFi_Item> WiFiList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_main);
        setTitle("와이파이");
        button = (Button) findViewById(R.id.button);

        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.Gmap);
        mapFrag.getMapAsync(this);


        //공공와이파이
        button = (Button)findViewById(R.id.button);


        String serviceUrl = "http://openAPI.seoul.go.kr:8088/";
        String serviceKey = "5a4f65447a6b79773132346b654d5870";
        String Url = serviceUrl + serviceKey + "/xml/PublicWiFiPlaceInfo/1/5/강남구";

        new DownloadWebpageTask().execute(Url);


    }//onCreate()

    /**ArrayList에 좌표값 대입**/

    public void addItem( String gpsX, String  gpsY) {
        WiFi_Item item = new WiFi_Item();

        item.setGpsX(Double.parseDouble(gpsX));
        item.setGpsY(Double.parseDouble(gpsY));

        WiFiList.add(item);
    }

    private class DownloadWebpageTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String)downloadUrl((String)urls[0]);
            } catch (IOException e) {
                return null;
            }
        }
        protected void onPostExecute(String result){
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance(); //파싱을하는 객체 => 파서
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();
                boolean WX = false, WY = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("INSTL_X"))
                            WX = true;
                        if (tag_name.equals("INSTL_Y"))
                            WY = true;
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (WX) {
                            String content = xpp.getText();
                            WiFi_Item i = new WiFi_Item();
                            i.setGpsX(Double.parseDouble(content));

                            WX = false;
                        }
                        if (WY) {
                            String content = xpp.getText();
                            WiFi_Item i = new WiFi_Item();
                            i.setGpsY(Double.parseDouble(content));

                        /**오픈API에서 좌표값을 얻어서 ArrayList에 저장**/

                            addItem("INSTL_X", "INSTL_Y");
                            WY = false;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {

                        ;
                    }
                    eventType = xpp.next();
                }

            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String downloadUrl(String myurl) throws IOException {
            HttpURLConnection conn = null;
            try {
                Log.d(tag, "downloadUrl : "+  myurl);
                URL url = new URL(myurl);
                conn = (HttpURLConnection) url.openConnection();
                BufferedInputStream buf = new BufferedInputStream(conn.getInputStream());
                BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));
                String line = null;
                String page = "";
                while((line = bufreader.readLine()) != null) {
                    page += line;
                }

                return page;
            } catch(Exception e){
                return " ";
            }
            finally {
                conn.disconnect();
            }
        }
    }

    /**지도 타입 설정 메뉴**/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"위성지도");
        menu.add(0,2,0,"일반지도");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //위성지도
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); //일반지도
                return true;

        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.651683, 127.016171), 15));
        //map:cameraTargetLat="37.651683"
        //map:cameraTargetLng="127.016171"
        //map:cameraZoom="15"

        gMap.getUiSettings().setZoomControlsEnabled(true);

        /**"와이파이 검색"버튼을 클릭하면
         * ArrayList에 저장된 좌표값들이
         * 구글맵 위에 Mark가 된다.       **/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat, lng;
                int size = WiFiList.size();

                for (int index = 0; index<size;index++) {
                    lat = WiFiList.get(index).getGpsX();
                    lng = WiFiList.get(index).getGpsY();
                    LatLng LatLng = new LatLng(lat,lng);

                    Mark = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp))
                            .position(LatLng,100f,100f);

                    gMap.addGroundOverlay(Mark);
                }

            }
        });
    }

}



