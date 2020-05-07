package kz.sirius.myapplication.entity;

import java.sql.Timestamp;

public class VadimItem {
    String title;
    Timestamp date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VadimsItem{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
