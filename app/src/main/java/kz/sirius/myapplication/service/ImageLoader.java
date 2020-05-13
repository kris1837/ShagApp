package kz.sirius.myapplication.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

public class ImageLoader implements Runnable {
    private Handler mHandlerThread;
    private String imageUrl;
    private Context context;

    public ImageLoader(Context context, Handler mHandlerThread,
                       String imageUrl) {
        this.mHandlerThread = mHandlerThread;
        this.imageUrl = imageUrl;
        this.context = context;
    }

    @Override
    public void run() {
        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(context)
                    .asBitmap()
                    .load(imageUrl)
                    .submit()
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        bundle.putByteArray("image", byteArray);
        message.setData(bundle);
        bitmap.recycle();
        mHandlerThread.sendMessage(message);
    }
}
