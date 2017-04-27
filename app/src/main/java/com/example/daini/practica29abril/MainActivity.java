package com.example.daini.practica29abril;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ImageView iw;
    private TextView tvres;
    private Bitmap bitmap;
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //encontrar xml atributos
        tvres = (TextView) findViewById(R.id.mitvres);
        iw = (ImageView) findViewById(R.id.miFoto);

        //capturar y guardar los datos recibidos de intent
        final Intent intent = getIntent();
        bitmap = intent.getParcelableExtra("foto");
        mensaje = intent.getStringExtra("mensaje");

        if (bitmap != null) {//Va bien, hay bitmap
            Log.e("DIMENSIONS", "Original Main Activity   dimensions = " + bitmap.getWidth() + " x " + bitmap.getHeight());

            //Recuperar el tamaño del bitmap
            int width = bitmap.getWidth() * 10;
            int height = bitmap.getHeight() * 10;
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
            Log.e("DIMENSIONS", "Changed Main Activity   dimensions = " + bitmap.getWidth() + " x " + bitmap.getHeight());
           //Setear xml atributos con valores
            tvres.setText(mensaje);
            iw.setImageBitmap(bitmap);
        }else {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog);
            dialog.show();

        }
    }
}
