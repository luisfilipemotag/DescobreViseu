package com.example.chip.descobreviseu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Chip on 23/04/2017.
 */

public class qrcode extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    View myview ;
    ImageView imagem;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }
        imagem = (ImageView)  getActivity().findViewById(R.id.imagemhome);
        imagem.setVisibility(View.INVISIBLE);
        myview=inflater.inflate(R.layout.qrcode, container , false);
        mScannerView  = new ZXingScannerView(getActivity());


        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
        //return myview;
        return (mScannerView);


    }
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Bundle qr;
        int valor ;
        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
        qr = new Bundle();
        // show the scanner result into dialog box.

        valor= Integer.valueOf(rawResult.getText());
            if (valor >8  ||valor < 0){
                Toast.makeText(getActivity(),"NAO É VALIDO ESSE QR-CODE", Toast.LENGTH_SHORT).show();
                qr.putInt("qr",10);
            }else {
        //Intent intencao= new Intent(getActivity(),Info_Monomento.class);
        Info_Monomento fragment1 = new Info_Monomento();

       // startActivity(intencao);

                qr.putInt("qr", valor);

    fragment1.setArguments(qr);

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.content_frame, fragment1);
    fragmentTransaction.commit();





        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);

    }

}
}




