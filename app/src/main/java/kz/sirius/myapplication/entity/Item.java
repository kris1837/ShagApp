package kz.sirius.myapplication.entity;

import java.io.Serializable;

public class Item implements Serializable {

    private String title;
    private String text;
    private String picture;

    public Item(String title, String text, String picture) {
        this.title = title;
        this.text = text;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPicture() {
        return picture;
    }
}
