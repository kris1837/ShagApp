package kz.sirius.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import kz.sirius.myapplication.activity.CustomViewsActivity;

public class HandlerYernar extends Handler {
    private WeakReference<AppCompatActivity> weakReference;

    public HandlerYernar(@NonNull Looper looper, AppCompatActivity activity) {
        super(looper);
        weakReference = new WeakReference<>(activity);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        byte[] byteArray = msg.getData().getByteArray("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Log.d("HandlerYernar", bitmap.getConfig().name());
        if (weakReference.get() instanceof CustomViewsActivity) {
            //((CustomViewsActivity) weakReference.get()).myTextView.setText("");
            Log.d("HandlerYernar", "in weak reference get");
        }
    }
}
