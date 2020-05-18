package kz.sirius.myapplication.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.adapter.SensorsAdapter;

import static android.hardware.Sensor.TYPE_ALL;
import static android.hardware.SensorManager.SENSOR_DELAY_FASTEST;

public class SensorsActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor accelerometer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        ///List<Sensor> sensorsList = sensorManager.getSensorList(TYPE_ALL);

        RecyclerView uiList = findViewById(R.id.uiList);
        SensorsAdapter adapter = new SensorsAdapter();
        //adapter.setContent(sensorsList);
        uiList.setAdapter(adapter);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                adapter.addContent(String.valueOf(event.values[0]) + " " + String.valueOf(event.values[1]) + " " + String.valueOf(event.values[2]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, accelerometer, SENSOR_DELAY_FASTEST);
    }
}
