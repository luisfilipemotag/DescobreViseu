package com.example.chip.descobreviseu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class listarp1 extends AppCompatActivity {

    DB_Helper dbH;
    ListView PVlista;
    List<DB_Premio> Lista;
    Button fechar;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarp1);

        dbH = new DB_Helper(getApplicationContext());
        Lista = dbH.listaPremio1();
        PVlista = (ListView) this.findViewById(R.id.listap1);

            AtualizaLista();


    }

    public void AtualizaLista() {
        ModelP1.LoadModelP1();
        for (int i = 0; i < Lista.size(); i++) {
            DB_Premio Atual = Lista.get(i);
            ModelP1.SetItemP1(new Item(Atual.getId_Premio(), Atual.getNome_Premio(), Atual.getNome_Premio()));


        }
        ItemAdapterP1 itemadapt = new ItemAdapterP1(MainActivity.context(), R.layout.linhap1, null);
        PVlista.setAdapter(itemadapt);

    }
    public void reset(View view){
        dbH.Resetpremio();
        Toast.makeText(this ,"Reset bem sucedido!!!", Toast.LENGTH_SHORT).show();
        AtualizaLista();
    }

    public void fechar(View view){

        Intent intecao = new Intent(this ,MainActivity.class);

        startActivity(intecao);
        listarp1.this.finish();
    }

}
