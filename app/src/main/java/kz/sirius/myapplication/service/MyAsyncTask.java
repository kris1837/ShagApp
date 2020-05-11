package kz.sirius.myapplication.service;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import kz.sirius.myapplication.activity.ImageActivity;

public class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {

    private Activity activity;

    public static String TAG = "MyAsyncTask";

    public MyAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onCancelled(Bitmap bitmap) {
        super.onCancelled(bitmap);
        activity = null;
    }

    @Override
    protected void onProgressUpdate(final Integer... values) {
        super.onProgressUpdate(values);
        ((ImageActivity)activity).runOnUiThread(new Runnable() {
            public void run() {
                ((ImageActivity) activity).uiCounter.setText(String.valueOf(values[0]));
            }
        });
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            // 1. Declare a URL Connection
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 2. Open InputStream to connection
            conn.connect();
            in = conn.getInputStream();
            // 3. Download and decode the bitmap using BitmapFactory
            bitmap = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "Exception while closing inputstream" + e);
                }
        }

        return bitmap;
    }

    // Fires after the task is completed, displaying the bitmap into the ImageView
    @Override
    protected void onPostExecute(Bitmap result) {
        if (activity instanceof ImageActivity) {
            ((ImageActivity) activity).imageView.setImageBitmap(result);
        }
    }
}
