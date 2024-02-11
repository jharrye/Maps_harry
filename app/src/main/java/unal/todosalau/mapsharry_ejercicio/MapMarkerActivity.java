package unal.todosalau.mapsharry_ejercicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MapMarkerActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;

    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_marker);
        map=findViewById(R.id.map);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap= googleMap;

        UiSettings settings= googleMap.getUiSettings();//aqui agregamos las opciones de zoon al map
        settings.setZoomControlsEnabled(true);


        //un marcador de una pocision exacta
        //acontinuacion ponemos la latitud y longitud (latLng)

        LatLng torrecolpatria= new LatLng(4.363496, -74.045430);//muestra el mapa
        this.gMap.addMarker(new MarkerOptions().position(torrecolpatria).title("torrecolpatria"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(torrecolpatria));//la camara

        //luego se copia el api_key de la paginad e google cloud en android manifest.xml
       //tambien se piden los permisos alocation interne etc.

        // <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION "/>
   // <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION "/>
   // <uses-permission android:name="android.permission.INTERNET "/>

        //asi queda el api_key en androidManifest:
       // <meta-data
       // android:name="com.goolge.android.geo.API_key"
        //android:value="AIzaSyB02arrw8HB1x8RxG5hj1hGbuCCk4ut6-4"/>  -->API_KEY copiado de  cloud


    }
}