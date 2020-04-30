package kz.sirius.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    public ImageView imageView;
    public TextView uiCounter;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.uiImage);
        uiCounter = findViewById(R.id.uiCounter);

        SharedPreferences sharedPref = getSharedPreferences("MyAppShared", Context.MODE_PRIVATE);
        sharedPref.edit()
                .putString("LINK", "https://media.kasperskydaily.com/wp-content/uploads/sites/92/2019/12/09084248/android-device-identifiers-featured.jpg")
                .apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("MyAppShared", Context.MODE_PRIVATE);
        String link = sharedPref.getString("LINK", "https://cnet1.cbsistatic.com/img/BnLyGuaT3eyRibEC0Ka8jxuclVs=/940x0/2019/12/10/92ed1148-cd42-489a-839f-b1be6889829d/android-10-pixel-4.jpg");

        myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute(link);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myAsyncTask.cancel(true);
    }

}
