package com.example.chip.descobreviseu;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Info_Monomento extends Fragment {

    String Nome,descricao,nomeI;
    int pontos;
    int valor;
    int totalpontos;
    int P_atuais;
    int estado;
    int test;

    TextView nome;
    TextView desc;
    TextView pont;
    ImageView imagem;
    DB_Helper dbH;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceStatee) {
        View fragmentView = inflater.inflate(R.layout.infomonumento, container, false);


        Bundle qr =getArguments();
        valor=qr.getInt("qr");
        Bundle M = getArguments();
        test = M.getInt("v");



        DB_Monumento value;
        dbH = new DB_Helper(getActivity());

        try {
            if (valor > 10 || valor <0){Toast.makeText(getActivity(), "Qrcode invalido", Toast.LENGTH_SHORT).show();}
            value = dbH.getInfoMonumento(valor);
            //Toast.makeText(getActivity(), value.getNome_m(), Toast.LENGTH_SHORT).show();
            Nome =value.getNome_m();
            estado=value.getEstado_Visita();
            pontos=value.getPontos_M();


            descricao=value.getDescricao();
            P_atuais= dbH.PontosA().getP_turista();

            if (test != 3) {
                if (estado == 0) {
                    dbH.updateEstadoM(1,valor);
                    dbH.updatePontos(pontos+P_atuais);
                } else if (estado == 1){
                    Log.e("pontos",String.valueOf( estado));
                    Toast.makeText(getActivity(),"este monumento ja foi visitado", Toast.LENGTH_SHORT).show();

                }
            }

            Log.d(" ",Nome);
            nome = (TextView) fragmentView.findViewById(R.id.textView2);
            nome.setText(Nome);
            desc=(TextView) fragmentView.findViewById(R.id.desc);
            desc.setText(descricao);
            pont =(TextView) fragmentView.findViewById(R.id.pmonumentos);
            pont.setText("Este monumento vale "+pontos+" pontos!");
            imagem = (ImageView) fragmentView.findViewById((R.id.imageView4)) ;



            nomeI= Nome.replace(" ","");
            int id= MainActivity.context().getResources().getIdentifier(nomeI,"drawable",MainActivity.context().getPackageName());
            imagem.setImageResource(id);
        }catch (Exception erro){ Toast.makeText(getActivity(),erro.getMessage(), Toast.LENGTH_SHORT).show();}



        qr.clear();
        dbH.close();
        return fragmentView;
    }
}
