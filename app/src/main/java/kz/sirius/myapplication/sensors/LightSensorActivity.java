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

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        final long[] id = {0};
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                id[0]++;
                series.appendData(new DataPoint(id[0], event.values[0]), false, 1024);
                graph.removeAllSeries();
                graph.addSeries(series);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, lightSensor, SENSOR_DELAY_FASTEST);
    }
}
