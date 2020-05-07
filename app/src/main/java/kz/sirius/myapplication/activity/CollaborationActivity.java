package kz.sirius.myapplication.activity;

import android.icu.util.Calendar;
import android.os.Bundle;

import java.sql.Timestamp;
import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.adapter.CollaborationAdapter;
import kz.sirius.myapplication.adapter.OnCollaborationClickListener;
import kz.sirius.myapplication.entity.AlibisEntity;
import kz.sirius.myapplication.entity.AmirkhanItem;
import kz.sirius.myapplication.entity.Drink;
import kz.sirius.myapplication.entity.EntityYernar;
import kz.sirius.myapplication.entity.LevsItem;
import kz.sirius.myapplication.entity.VadimItem;
import kz.sirius.myapplication.entity.VladItem;

public class CollaborationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_collaboration);

        RecyclerView uiListView = findViewById(R.id.uiListView);

        CollaborationAdapter adapter = new CollaborationAdapter(new OnCollaborationClickListener() {
            @Override
            public void onItemClicked(int position) {

            }
        });

        ArrayList<Object> list = new ArrayList<>();
        list.add(new VladItem("Vlad", 1, "Astana"));
        list.add(new Drink("Drink", "Company", true, true, true));
        list.add(new AlibisEntity("Nur-Sultan", "17", "4"));
        list.add(new EntityYernar("Yernar connection", "Some text"));
        list.add(new LevsItem(""));
        list.add(new VadimItem("Task №1", new Timestamp(System.currentTimeMillis())));
        list.add(new AmirkhanItem("Hello","ic_imageSource","World!!!"));

        adapter.setItems(list);

        uiListView.setAdapter(adapter);
    }
}
