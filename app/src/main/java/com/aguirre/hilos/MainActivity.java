package com.aguirre.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private boolean is_comenzando = false;
    private int contador = 0;
    private TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContador = findViewById(R.id.txtContador);
    }

    public void onclickHiloPrincipal(View view){
        is_comenzando = true;
        while (is_comenzando){
            contador++;
            tvContador.setText(String.valueOf(tvContador));
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onclickHiloSecundario(View view){
        is_comenzando = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (is_comenzando){
                    contador++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { tvContador.setText(String.valueOf(contador));}
                    });
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void onclickSecundarioFinal(View view){
        is_comenzando = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (is_comenzando){
                    contador++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {tvContador.setText(String.valueOf(contador));}
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}