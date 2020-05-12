package kz.sirius.myapplication.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

public class EvgeniyAsyncTask extends AsyncTask<String, Integer, Double> {
    private TextView text;

    public static String TAG = "EvgeniyAsyncTask";

    public EvgeniyAsyncTask(TextView text) {
        this.text = text;
    }

    @Override
    protected void onCancelled(Double pi) {
        super.onCancelled(pi);
        text = null;
    }

    @Override
    protected Double doInBackground(String... strings) {
        double pi = 3 + 4.0/(2*3*4) - 4.0/(4*5*6);

        int a = 6, b = 7, c = 8;

        for (int i = 0; i < 10; i++) {

            pi += 4.0 / (a * b * c);
            a += 2;
            b += 2;
            c += 2;
            pi -= 4.0 / (a * b * c);
            a += 2;
            b += 2;
            c += 2;
        }

        return pi;
    }

    @Override
    protected void onPostExecute(Double result) {
        text.setText(result.toString());
    }
}
