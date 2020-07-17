package com.example.chip.descobreviseu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


/**
 * Created by Chip on 12/05/2017.
 */

public class Premio extends Fragment{

    View myview ;
    View refresh;
    DB_Helper dbH;
    int pontos;
    ListView PVlista;
    TextView pontosP0;
    List<DB_Premio> Lista;
    ImageView imagem;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.preimio, container , false);
        if (container != null) {
            container.removeAllViews();
        }
        dbH =new DB_Helper(getActivity());
        Lista = dbH.listaPremio0();
        PVlista=(ListView) myview.findViewById(R.id.ListaP0);
        pontosP0 =(TextView) myview.findViewById(R.id.PontosP0);

        pontos = dbH.PontosA().getP_turista();
        pontosP0.setText(String.valueOf(pontos));
        AtualizaLista();
        imagem = (ImageView)  getActivity().findViewById(R.id.imagemhome);
        imagem.setVisibility(View.INVISIBLE);

        PVlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("PontosT",String.valueOf(pontos));
                int valor = Lista.get(position).getId_Premio();
                int Preco = dbH.getPP(valor).getPontos_P();
                Log.e("valor",String.valueOf(valor));
                if ( pontos < Preco){Toast.makeText(getActivity(),"Pontos insuficientes", Toast.LENGTH_SHORT).show();}else
                    {dbH.updatePontos(pontos - Preco);
                        dbH.Updatepremio(valor);
                        Toast.makeText(getActivity(),"O seu premio ja foi convertido! dirija-se a um centro turistico mais proximo", Toast.LENGTH_SHORT).show();

                        AtualizaLista();

                        android.app.FragmentManager manage = getFragmentManager();
                        manage.beginTransaction()
                                .replace(R.id.content_frame
                                        , new Premio()).commit();
                    }

            }

        });

        return myview;
    }
    public void AtualizaLista(){
        ModelP0.LoadModelP0();
        for (int i =0 ; i<Lista.size(); i++){
            DB_Premio Atual =Lista.get(i);
            ModelP0.SetItemP0(new Item(Atual.getId_Premio(), Atual.getNome_Premio() ,Atual.getNome_Premio()));


        }
        ItemAdapterP0 itemadapt= new ItemAdapterP0(MainActivity.context() , R.layout.linhap0, null);
        PVlista.setAdapter(itemadapt);

    }
}

