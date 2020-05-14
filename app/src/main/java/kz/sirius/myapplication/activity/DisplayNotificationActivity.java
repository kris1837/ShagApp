package kz.sirius.myapplication.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.service.JonnyWakerService;

public class DisplayNotificationActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "1";
    public static final int NOTIFICATION_ID = 100;
    public Bitmap notificationBmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_notification_activity);

        createNotificationChannel();

        Button uiSendNotificationBtn = findViewById(R.id.uiSendNotificationBtn);
        Button btn_notification = findViewById(R.id.notification_yernar);

        uiSendNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 100; i++) {
                    showNotification("Notification number: " + String.valueOf(i), i);
                }
            }
        });

        if(notificationBmp == null){
            notificationBmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.notif_image);
        }
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (this) {
                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(getBaseContext(), CHANNEL_ID)
                                    .setSmallIcon(R.drawable.ic_attach_money_black_24dp)
                                    .setContentTitle("Yernar notify")
                                    .setContentText("Look at this")
                                    .setLargeIcon(notificationBmp)
                                    .setStyle(new NotificationCompat.BigPictureStyle()
                                            .bigPicture(notificationBmp)
                                            .bigLargeIcon(null))
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getBaseContext());

                    notificationManager.notify(8, builder.build());
                }
            }
        });

        Button uiStartService = findViewById(R.id.uiStartService);
        uiStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JonnyWakerService.class);
                startService(intent);
            }
        });

    }

    private void showNotification(String text, int notificationId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_directions_walk_black_24dp)
                .setContentTitle(text)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(notificationId, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "HelloChennal", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("FirstNotification");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
