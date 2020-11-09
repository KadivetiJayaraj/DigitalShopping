package com.example.photoprint.model;

public class Products {

    private int image;
    private String title;
    private String offer_price;
    private String sale_price;

    public Products(int image, String title, String offer_price, String sale_price) {
        this.image = image;
        this.title = title;
        this.offer_price = offer_price;
        this.sale_price = sale_price;
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

    public String getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(String offer_price) {
        this.offer_price = offer_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }
}
