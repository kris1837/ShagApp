package kz.sirius.myapplication.entity;

import java.io.Serializable;

public class UserSerializable implements Serializable {

    private String name;
    private String password;

    public UserSerializable(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
