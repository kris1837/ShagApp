package kz.sirius.myapplication.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;

import java.util.List;


import kz.sirius.myapplication.utils.Utils;
import kz.sirius.myapplication.entity.City;

public class JsonProcessor implements Runnable {

    private Context context;
    private String fileName;
    private Handler mHandlerThread;

    public JsonProcessor(Context context, String fileName, Handler mHandlerThread) {
        this.context = context;
        this.fileName = fileName;
        this.mHandlerThread = mHandlerThread;
    }

    @Override
    public void run() {
        List<City> result = Utils.getJsonFromAssets(context, fileName);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("Message", (Parcelable[]) result.stream().toArray(City[]::new));
        message.setData(bundle);
        mHandlerThread.sendMessage(message);
    }
}
