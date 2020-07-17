package com.example.chip.descobreviseu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Chip on 23/04/2017.
 */

public class mpa extends Fragment {

    View myview ;
ImageView imagem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.mpa , container , false);
        if (container != null) {
            container.removeAllViews();
        }
        imagem = (ImageView)  getActivity().findViewById(R.id.imagemhome);
        imagem.setVisibility(View.INVISIBLE);
        return myview;

    }

/*
    @Override
    public void onResume(){
        super.onResume();
        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.mpa);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(40.658021, -7.913137), 16));
        // Add a marker

        LatLng Rossio = new LatLng(40.65753, -7.914175);
        mMap.addMarker(new MarkerOptions().position(Rossio).title("Rossio"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rossio));
    }
*/
}
