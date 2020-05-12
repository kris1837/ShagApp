package kz.sirius.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class City implements Parcelable {
    private int id;
    private String name;
    private String state;
    private String country;
    private Coord coord;


    protected City(Parcel in) {
        id = in.readInt();
        name = in.readString();
        state = in.readString();
        country = in.readString();
        coord = in.readParcelable(Coord.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(country);
        dest.writeParcelable(coord, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Coord getCoord() {
        return coord;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCoord(Coord coordObject) {
        this.coord = coordObject;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof City)){
            return  false;
        }
        City city = (City)obj;
        return this.name.compareTo(city.name) == 0 && this.id == city.id;
    }
}
