package kz.sirius.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    final String TAG = "RegistrationActivity";

    String password = "";
    String login = "";

    final String ourPassword = "12345";
    final String ourLogin = "root";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Log.d(TAG, "OnCreate");
        final EditText uiLogin = findViewById(R.id.uiLogin);
        uiLogin.setText("root");
        final EditText uiPassword = findViewById(R.id.uiPassword);
        uiPassword.setText("12345");
        Button uiBtn = findViewById(R.id.uiBtn);

        uiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = uiLogin.getText().toString();
                password = uiPassword.getText().toString();

                Log.i(TAG, login + " " + password);

                if (login.equals(ourLogin) && password.equals(ourPassword)) {
                    Log.i(TAG, "Success");

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("DATA", 1);
                    startActivity(intent);
                } else {
                    Log.i(TAG, "Wrong");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }
}
