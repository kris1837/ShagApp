package kz.sirius.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.entity.LevsItem;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.adapter.MyRecyclerAdapter;
import kz.sirius.myapplication.entity.UserParcel;
import kz.sirius.myapplication.entity.UserSerializable;
import kz.sirius.myapplication.entity.VladItem;
import kz.sirius.myapplication.viewHolders.VladViewHolder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int numberFromReg;
    private UserParcel userFromRegParc;
    private UserSerializable userFromRegSer;
    private static final String TAG = "MainActivity";
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        if (getIntent().getExtras() != null) {

            numberFromReg = getIntent().getExtras().getInt("DATA");
            userFromRegSer = (UserSerializable) getIntent().getExtras().getSerializable("DATA_SERIALIZE");
            userFromRegParc = (UserParcel) getIntent().getExtras().getParcelable("DATA_PARCEL");
        }
        



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Log.d(TAG, "OnCreate");

        ArrayList list = new ArrayList<LevsItem>();
        for (int i = 0; i < 20; i++) {
            list.add(new LevsItem("NiceTitle", "Description", ""));
        }

        RecyclerView uiList = findViewById(R.id.uiList);
        MyRecyclerAdapter listAdapter = new MyRecyclerAdapter();
        listAdapter.setContent(list);
        uiList.setAdapter(listAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        uiList.setLayoutManager(layoutManager);

        Button uiScrollTo = findViewById(R.id.uiScrollTo);
        uiScrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManager.scrollToPositionWithOffset(0, 20);
            }
        });

        Button uiToGallery = findViewById(R.id.uiToGallery);
        uiToGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    readFile();
                }
            }
        });
    }

    private void readFile() {
        File files[] = ContextCompat.getExternalFilesDirs(MainActivity.this, null);

        Log.d("Files", "Size: " + files.length);
        for (int i = 0; i < files.length; i++) {
            Log.d("Files", "FileName:" + files[i].getPath());
        }
    }

    private void openGallery(){
        Intent getImageIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getImageIntent.setType("image/*");
        startActivityForResult(getImageIntent , 11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            Uri fullPhotoUri = data.getData();
            ImageView uiImageView = findViewById(R.id.uiImageView);
            uiImageView.setImageURI(fullPhotoUri);
        }
    }

    public boolean isPermissionGranted() {
        String permissionArray[] = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    permissionArray,
                    1);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (item.getItemId() == R.id.action_1) {
            Toast.makeText(this, "Action1 Clikced", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
