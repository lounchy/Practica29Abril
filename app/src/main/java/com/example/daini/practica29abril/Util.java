package com.example.daini.practica29abril;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;



public class Util {
    private Bitmap bitmap;
    private String mensaje, titulo, texto;
    private Context context;

    public Util(Context context) {
        this.context = context;
    }

    public Bitmap getBitmap() {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.frogs);
        return bitmap;
    }

    public String getMensaje() {
        mensaje = "Te gusta la foto?";
        return mensaje;
    }

    public String getTitulo() {
        titulo = "Nuevo mensaje";
        return titulo;
    }

    public String getTexto() {
        texto = "Foto";
        return texto;
    }
}
