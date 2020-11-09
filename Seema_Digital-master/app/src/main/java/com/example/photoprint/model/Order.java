package com.example.photoprint.model;

public class Order {

    private String order_id;
    private String seller_id;
    private String status;
    private int image;
    private String title;
    private String date;
    private String amount;
    private String total_amount;

    public Order(String order_id, String seller_id, String status, int image, String title, String date, String amount, String total_amount) {
        this.order_id = order_id;
        this.seller_id = seller_id;
        this.status = status;
        this.image = image;
        this.title = title;
        this.date = date;
        this.amount = amount;
        this.total_amount = total_amount;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
}
