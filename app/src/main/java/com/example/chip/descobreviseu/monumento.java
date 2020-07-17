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

public class monumento extends Fragment {

    View myview;
    View nova;
    DB_Helper dbH;
    ListView lvlista;
    List<DB_Monumento> Lista;
    ImageView imagem;
    int id;
    @Nullable
    @Override

    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.monumento, container, false);
        if (container != null) {
            container.removeAllViews();
        }
        imagem = (ImageView)  getActivity().findViewById(R.id.imagemhome);
        imagem.setVisibility(View.INVISIBLE);
        dbH = new DB_Helper(getActivity());
        Lista = dbH.listaMonumento();
        lvlista = (ListView) myview.findViewById(R.id.listaM);
        AtualizaLista();







        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle M;
                int valor = Lista.get(position).getID_monumento();
                int v = 3;
                Info_Monomento fragment1 = new Info_Monomento();
                M = new Bundle();
                M.putInt("qr", valor);
                M.putInt("v", v);



                fragment1.setArguments(M);

                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment1);
                fragmentTransaction.commit();


            }

        });
        return myview;
    }

    public void AtualizaLista() {
        Model.LoadModel();

        for (int i = 0; i < Lista.size(); i++) {
            DB_Monumento Atual = Lista.get(i);
            Model.SetItem(new Item(Atual.getID_monumento(), Atual.getNome_m(), Atual.getNome_m()));


        }
        ItemAdapter itemadapt = new ItemAdapter(MainActivity.context(), R.layout.linha, null);
        lvlista.setAdapter(itemadapt);

    }


}
