package kz.sirius.myapplication.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import kz.sirius.myapplication.R;

public class JonnyWakerService extends Service {

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 60 seconds.
            long endTime = System.currentTimeMillis() + 10 * 1000;
            long oldTime = System.currentTimeMillis();
            while (System.currentTimeMillis() < endTime) {
                synchronized (this) {
                    try {
                        wait(endTime - System.currentTimeMillis());
                        if (System.currentTimeMillis() - 1000 >= oldTime) {
                            oldTime = System.currentTimeMillis();
                            showNotification("Counter:" + String.valueOf(System.currentTimeMillis()), 1);
                        }
                    } catch (Exception e) {
                    }
                }
            }
            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    private void showNotification(String text, int notificationId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_directions_walk_black_24dp)
                .setContentTitle(text)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(notificationId, builder.build());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments");
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);

        startForeground(1, getNotification("Service started", 1));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }


    private Notification getNotification(String text, int notificationId) {
        return new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_directions_walk_black_24dp)
                .setContentTitle(text)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }
}
