package com.example.chip.descobreviseu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Chip on 11/05/2017.
 */

public class ItemAdapter extends ArrayAdapter{
    private final Context context;
    private final int idLinha;
    private final int[] ListaID;

    public ItemAdapter(@NonNull Context context, @LayoutRes int idLinha, int[]listaID ) {
        super(context, idLinha);
        this.context=context;
        this.idLinha=idLinha;
        this.ListaID=listaID;
    }
    @Override
    public View getView(int position , View convertView , ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Linha = inflater.inflate(idLinha,parent,false);
        TextView texto=  (TextView) Linha.findViewById(R.id.nomeLista);
        texto.setText(Model.getItem(position).nome);
        ImageView imagem =(ImageView) Linha.findViewById(R.id.imagemLista);
        String caminho= Model.getItem(position).nome;
         caminho = caminho.replace(" ","");
        Log.e("strings", caminho);

  /*      InputStream strea =null;
        try{
            File ficheiro = new File(caminho);
            strea= new FileInputStream(ficheiro);
            Drawable d = Drawable.createFromStream(strea, null);
            imagem.setImageDrawable(d);
            strea.close();
            ficheiro =null;
        }
        catch (Exception erro){
            Log.e("erroLer" , erro.getMessage());
        }*/
  int id= MainActivity.context().getResources().getIdentifier(caminho,"drawable",MainActivity.context().getPackageName());
  imagem.setImageResource(id);


        return Linha;
    }
    @Override
    public  int getCount(){return Model.items.size();}
}

