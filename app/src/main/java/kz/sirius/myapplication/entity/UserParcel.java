package kz.sirius.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class UserParcel implements Parcelable {

    private String name;
    private String password;
    private boolean isLoggedIn;

    public UserParcel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    protected UserParcel(Parcel in) {
        name = in.readString();
        password = in.readString();
        isLoggedIn = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
        dest.writeByte((byte) (isLoggedIn ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserParcel> CREATOR = new Creator<UserParcel>() {
        @Override
        public UserParcel createFromParcel(Parcel in) {
            return new UserParcel(in);
        }

        @Override
        public UserParcel[] newArray(int size) {
            return new UserParcel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
