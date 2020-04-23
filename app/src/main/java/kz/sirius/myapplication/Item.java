package kz.sirius.myapplication;

public class Item {

    String title;
    String text;
    String picture;

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
