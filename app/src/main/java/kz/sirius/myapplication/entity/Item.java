package kz.sirius.myapplication.entity;

public class Item {

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
