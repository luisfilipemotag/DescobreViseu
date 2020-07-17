package com.example.chip.descobreviseu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Loginadmin extends AppCompatActivity {
    TextView Admin ;
    TextView pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);

    }
    public void listarP(View view){

        Admin=(TextView) findViewById(R.id.txt_nome);
        pass=(TextView) findViewById(R.id.txt_pass);

        Log.e("valor",pass.getText().toString());
        if (pass.getText().toString().equals("12345") && Admin.getText().toString().equals("admin"))
        {
             Intent intecao = new Intent(this ,listarp1.class );
            startActivity(intecao);
            Loginadmin.this.finish();
        }
        else {
            Toast.makeText(this, "O nome ou pass estao incorretas", Toast.LENGTH_SHORT).show();}
    }
}
