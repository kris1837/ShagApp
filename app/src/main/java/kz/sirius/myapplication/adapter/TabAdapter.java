package kz.sirius.myapplication.adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> listOfFragments = new ArrayList<>();
    private ArrayList<String> listOfTitles = new ArrayList<>();

    public void setListOfFragments(ArrayList<Fragment> listOfFragments) {
        this.listOfFragments = listOfFragments;
    }

    public void setListOfTitles(ArrayList<String> listOfTitles) {
        this.listOfTitles = listOfTitles;
    }

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listOfTitles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listOfFragments.get(position);
    }

    @Override
    public int getCount() {
        return listOfFragments.size();
    }
}
