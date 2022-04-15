package com.example.comicapp.Comic;

import java.lang.reflect.Array;

public class Comic {
    private String _id;
    private String name;
    private String author;
    private String category;
    private String image;
    private String content;
    private String[] imagecontent;

    public Comic() {
    }

    public Comic(String _id, String name, String author, String category, String image, String content, String[] imagecontent) {
        this._id = _id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.image = image;
        this.content = content;
        this.imagecontent = imagecontent;
    }

    public Comic(String name, String author, String category, String image, String content) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.image = image;
        this.content = content;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getImagecontent() {
        return imagecontent;
    }

    public void setImagecontent(String[] imagecontent) {
        this.imagecontent = imagecontent;
    }

}
