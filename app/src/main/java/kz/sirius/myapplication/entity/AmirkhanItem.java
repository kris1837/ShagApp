package kz.sirius.myapplication.entity;

import java.util.Objects;

public class AmirkhanItem {
    private String _id;
    private String _header;
    private String _imageSource;
    private String _content;

    @Override
    public String toString() {
        return "AmirkhanItem{" +
                "_id='" + _id + '\'' +
                ", _header='" + _header + '\'' +
                ", _content='" + _content + '\'' +
                ", _iamgeSource='" + _imageSource + '\'' +
                '}';
    }



    public String get_imageSource() {
        return _imageSource;
    }

    public void set_imageSource(String _iamgeSource) {
        this._imageSource = _iamgeSource;
    }



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_header() {
        return _header;
    }

    public void set_header(String _header) {
        this._header = _header;
    }

    public String get_content() {
        return _content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmirkhanItem that = (AmirkhanItem) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_header, that._header) &&
                Objects.equals(_content, that._content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _header, _content);
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public AmirkhanItem(String _header, String _imageSource, String _content) {
        this._header = _header;
        this._imageSource = _imageSource;
        this._content = _content;
    }
}
