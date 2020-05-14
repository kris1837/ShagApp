package kz.sirius.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kz.sirius.myapplication.CustomView;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.City;
import kz.sirius.myapplication.service.ImageLoader;
import kz.sirius.myapplication.service.JsonProcessor;
import kz.sirius.myapplication.utils.HandlerYernar;

public class CustomViewsActivity extends AppCompatActivity {

    Handler mHandlerThread;
    Handler mHandlerThreadYernar;
    Thread mThread;
    Thread mThreadYernar;
    TextView myTextView;
    public ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        ViewGroup rootLayout = findViewById(android.R.id.content);
        rootLayout.addView(new CustomView(this));
        imageView = findViewById(R.id.image_view);
        mHandlerThread = new MyHandler(Looper.getMainLooper(), this);

        Runnable processJsonThread = new JsonProcessor(this, "city.list.json", mHandlerThread);
        mThread = new Thread(processJsonThread);
        mThread.start();

        mHandlerThreadYernar = new HandlerYernar(Looper.getMainLooper(), this);
        Runnable procces = new ImageLoader(this, mHandlerThreadYernar, "https://www.freepngimg.com/thumb/hair/21-women-hair-png-image.png");
        mThreadYernar = new Thread(procces);
        mThreadYernar.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandlerThread.removeCallbacksAndMessages(null);
    }

    class MyHandler extends Handler {

        private WeakReference<AppCompatActivity> weakReference;

        public MyHandler(@NonNull Looper looper, AppCompatActivity activity) {
            super(looper);
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            City[] citylist = (City[]) msg.getData().getParcelableArray("Message");
            for (int i = 0; i < citylist.length; i++) {
                Log.d("CustomViewsActivity", citylist[i].getName() + " " + citylist[i].getCountry());
            }
            if (weakReference.get() instanceof CustomViewsActivity) {
                //((CustomViewsActivity) weakReference.get()).myTextView.setText("");
            }
        }
    }

}
