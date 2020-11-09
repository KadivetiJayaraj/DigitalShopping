package com.example.photoprint.model;

public class Offers {

    private int image;
    private String title;
    private String code;
    private String valid;

    public Offers(int image, String title, String code, String valid) {
        this.image = image;
        this.title = title;
        this.code = code;
        this.valid = valid;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
