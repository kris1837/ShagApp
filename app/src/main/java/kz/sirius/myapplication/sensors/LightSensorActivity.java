package kz.sirius.myapplication.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.adapter.SensorsAdapter;

import static android.hardware.SensorManager.SENSOR_DELAY_FASTEST;

public class LightSensorActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor lightSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        RecyclerView uiList = findViewById(R.id.uiList);
        SensorsAdapter adapter = new SensorsAdapter();
        uiList.setAdapter(adapter);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                adapter.addContent(String.valueOf(event.values[0]) + " " + String.valueOf(event.values[1]) + " " + String.valueOf(event.values[2]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, lightSensor, SENSOR_DELAY_FASTEST);
    }
}
