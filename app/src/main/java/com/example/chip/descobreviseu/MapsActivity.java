package com.example.chip.descobreviseu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
DB_Helper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(40.658021, -7.913137), 16));
        LatLng a= new LatLng(40.65753, -7.914175 );
        LatLng b= new LatLng(40.65847, -7.913308 );
        LatLng c= new LatLng(40.65818, -7.913489 );
        LatLng d= new LatLng(40.65630, -7.914436 );
        LatLng e= new LatLng(40.65969, -7.910986 );
        LatLng f= new LatLng(40.65910, -7.910492 );
        LatLng g= new LatLng(40.65759, -7.912619 );
        LatLng h= new LatLng(40.65528, -7.916014 );
        mMap.addMarker(new MarkerOptions().position(a).title("Praça da República"));
        mMap.addMarker(new MarkerOptions().position(b).title("Museu de Almeida Moreira"));
        mMap.addMarker(new MarkerOptions().position(c).title("jardim das mães"));
        mMap.addMarker(new MarkerOptions().position(d).title("igreja da Ordem Terceira de S. Francisco"));
        mMap.addMarker(new MarkerOptions().position(e).title("Catedral de Santa Maria de Viseu"));
        mMap.addMarker(new MarkerOptions().position(f).title("Rua Direita"));
        mMap.addMarker(new MarkerOptions().position(g).title("Rua Formosa"));
        mMap.addMarker(new MarkerOptions().position(h).title("parque Aquilino Ribeiro"));





/*
        dbh = new DB_Helper(getApplicationContext());
        for (int i=1 ; i<10 ; i++){

            dbh.Mapa(i);
            String nome = dbh.Mapa(i).getNome_m();
            String lat = dbh.Mapa(i).getLatitude();
            String Longg= dbh.Mapa(i).getLongitude();
            LatLng e= new LatLng( Double.valueOf(lat),Double.valueOf(Longg));
            mMap.addMarker(new MarkerOptions().position(e).title(nome));

        }


        dbh.closeDB();
*/

    }
}
