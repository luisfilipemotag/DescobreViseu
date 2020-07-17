package com.example.chip.descobreviseu;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chip on 11/05/2017.
 */

public class ItemAdapterP1 extends ArrayAdapter{
    private final Context context;
    private final int idLinha;
    private final int[] ListaID;

    public ItemAdapterP1(@NonNull Context context, @LayoutRes int idLinha, int[]listaID ) {
        super(context, idLinha);
        this.context=context;
        this.idLinha=idLinha;
        this.ListaID=listaID;
    }
    @Override
    public View getView(int position , View convertView , ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Linha = inflater.inflate(idLinha,parent,false);
        TextView texto=  (TextView) Linha.findViewById(R.id.nomeListap1);
        texto.setText(ModelP1.getItemP1(position).nome);
        ImageView imagem =(ImageView) Linha.findViewById(R.id.imagemListap1);
        String caminho= ModelP1.getItemP1(position).nome;

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
    public  int getCount(){return ModelP1.items.size();}
}

