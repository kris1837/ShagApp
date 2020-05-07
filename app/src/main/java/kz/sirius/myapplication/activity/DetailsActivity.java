package kz.sirius.myapplication.activity;


import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.adapter.TabAdapter;
import kz.sirius.myapplication.entity.LevsItem;
import kz.sirius.myapplication.fragment.Fragment1;
import kz.sirius.myapplication.fragment.Fragment2;
import kz.sirius.myapplication.fragment.FragmentListener;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class DetailsActivity extends AppCompatActivity implements FragmentListener {

    public static final String TAG = "DetailsActivity";

    Fragment1 fragment;
    Fragment2 fragment2;
    Fragment1 fragment3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate");
        setContentView(R.layout.activity_with_fragment_two);


        fragment = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Item", new LevsItem("", "", ""));
        fragment.setArguments(bundle);
        fragment2 = new Fragment2();
        fragment3 = new Fragment1();

        TabLayout uiTabLayout = findViewById(R.id.uiTabLayout);
        ViewPager uiViewPager = findViewById(R.id.uiViewPager);


        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ArrayList<Fragment> listOfFragment = new ArrayList<>();
        listOfFragment.add(fragment);
        listOfFragment.add(fragment2);
        listOfFragment.add(fragment3);
        adapter.setListOfFragments(listOfFragment);

        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Fragment1");
        listOfStrings.add("Fragment2");
        listOfStrings.add("Fragment3");

        adapter.setListOfTitles(listOfStrings);

        uiViewPager.setAdapter(adapter);
        uiTabLayout.setupWithViewPager(uiViewPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
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

    @Override
    public void onChangeTextClicked() {
        Toast.makeText(this, "TextChangeClicked", Toast.LENGTH_LONG).show();
        fragment2.setText("New text");
    }
}
