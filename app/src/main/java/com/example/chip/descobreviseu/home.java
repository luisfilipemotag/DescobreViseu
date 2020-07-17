package com.example.chip.descobreviseu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Chip on 16/05/2017.
 */

public class home extends Fragment {
    View myview;
    ImageView imagem;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.home, container, false);
        if (container != null) {
            container.removeAllViews();
        }

        return myview;
    }
}
