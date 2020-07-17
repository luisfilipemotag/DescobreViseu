package com.example.chip.descobreviseu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PrimeiroLogin extends AppCompatActivity {
    DB_Helper Dbh;
    TextView Nome ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int check;
        super.onCreate(savedInstanceState);

        Dbh= new DB_Helper(getApplicationContext());
        check= Dbh.getTurisa();


        if (   check ==1 ){

            Intent intecao = new Intent(this ,MainActivity.class);
            startActivity(intecao);
        }
        else {
            setContentView(R.layout.activity_primeiro_login);
        }

    }

    public void OnStart2(View view) {
        Nome= (TextView) findViewById(R.id.NomeT);
        Log.e("nome", Nome.getText().toString());
        Dbh =new DB_Helper(getApplicationContext());
        Dbh.nomeT(Nome.getText().toString());

        Intent intecao = new Intent(this ,MainActivity.class);
        startActivity(intecao);
        PrimeiroLogin.this.finish();
    }

}
