package com.example.photoprint.model;

public class Cart {

    private int image;
    private String title;
    private String amount;

    public Cart(int image, String title, String amount) {
        this.image = image;
        this.title = title;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
