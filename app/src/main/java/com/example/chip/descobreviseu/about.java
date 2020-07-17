package com.example.chip.descobreviseu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chip on 23/04/2017.
 */

public class about extends Fragment { View myview;
    ImageView imagem;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.about, container, false);
        if (container != null) {
            container.removeAllViews();
        }
        imagem = (ImageView)  getActivity().findViewById(R.id.imagemhome);
        imagem.setVisibility(View.INVISIBLE);
        return myview;
    }

}