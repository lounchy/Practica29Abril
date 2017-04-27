package com.example.daini.practica29abril;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MiReceiver extends BroadcastReceiver {
    private Bitmap bitmap;
    private String mensaje, titulo, texto;


    public MiReceiver( ) {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Encontrar constantes
        Util util = new Util(context);
        bitmap = util.getBitmap();
        titulo = util.getTitulo();
        texto = util.getTexto();
        mensaje = util.getMensaje();

        Log.e("DIMENSIONS","Original MiReceiver   dimensions = "+ bitmap.getWidth() + " x " + bitmap.getHeight() + " size " + bitmap.getAllocationByteCount());

        //declarar nuevo width y height
        int width = bitmap.getWidth()/10;
        int height = bitmap.getHeight()/10;
        //cambiar el tamaño de bitmap para poder pasar via intent
        bitmap = Bitmap.createScaledBitmap(bitmap,width , height, false);
        Log.e("DIMENSIONS","Changed MiReceiver   dimensions = "+ bitmap.getWidth() + " x " + bitmap.getHeight()+ " size " + bitmap.getAllocationByteCount());

       //Prepar Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        //setear atributos
        builder.setSmallIcon(R.drawable.icono);
        builder.setColor(Color.GREEN);
        builder.setContentTitle(titulo);
        builder.setContentText(texto);
        builder.setAutoCancel(true);
        //Preparar Intent
        Intent resultIntent = new Intent(context, MainActivity.class);
        //añadir extras
        resultIntent.putExtra("mensaje", mensaje);
        resultIntent.putExtra("foto", bitmap);

        //Preparar pending intent
        PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(),resultIntent ,PendingIntent.FLAG_ONE_SHOT);
        //
        builder.setContentIntent(pendingIntent);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        //
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        notificationManager.notify(123, notification);

    }

}
