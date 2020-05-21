package kz.sirius.myapplication.sensors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import kz.sirius.myapplication.R;

public class GlobalSensorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_sensor);

        Button uiLight = findViewById(R.id.uiLight);
        Button uiMagnitometer = findViewById(R.id.uiMagnitometer);
        Button uiGyroscope = findViewById(R.id.uiGyroscope);

        uiLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LightSensorActivity.class);
                startActivity(intent);
            }
        });

        uiMagnitometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MagnetometerActivity.class);
                startActivity(intent);
            }
        });


    }
}
