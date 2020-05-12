package kz.sirius.myapplication;

import java.util.Comparator;

import kz.sirius.myapplication.entity.City;

public class SortCityByName implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
