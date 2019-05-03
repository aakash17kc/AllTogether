package com.example.notificaation;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;

public class NotificationHandler {
    private static final String CHANNEL_ID = "1001";
    public static final int NOTIFICAITON_ID = 100;
    public static final String TXT_REPLY = "re";
    Context context;

    NotificationManagerCompat notificationManagerCompat;
    NotificationCompat.Builder notificationCompat;


    public NotificationHandler(Context context) {
        this.context = context;
    }

    public void showNotificaiotn(){
        notifcationChannel();

        Intent intent = new Intent(context,Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_ONE_SHOT);

        notificationCompat = new NotificationCompat.Builder(context,CHANNEL_ID);
        notificationCompat.setPriority(NotificationCompat.PRIORITY_HIGH);
        notificationCompat.setSmallIcon(R.drawable.ic_launcher_background);
        notificationCompat.setContentText("THis is notification");
        notificationCompat.setContentTitle("Hey There");
        notificationCompat.setContentIntent(pendingIntent);

        notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(NOTIFICAITON_ID,notificationCompat.build());

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {

            RemoteInput remoteInput = new RemoteInput.Builder(TXT_REPLY).setLabel("Reply..").build();


            Intent intent1 = new Intent(context,Main2Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent1 = PendingIntent.getActivity(context,0,intent1,PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,"Reply123",pendingIntent1).addRemoteInput(remoteInput).build();
            notificationCompat.addAction(action);

        }

        notificationManagerCompat.notify(NOTIFICAITON_ID,notificationCompat.build());







    }

    private void notifcationChannel() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name = "Aakash";
            String description = "Hey";

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);


        }
    }


}
