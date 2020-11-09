package com.example.photoprint.model;

public class Tickets {

    private String ticket_id;
    private String order_id;
    private String subject;
    private String status;
    private String category;

    public Tickets(String ticket_id, String order_id, String subject, String status, String category) {
        this.ticket_id = ticket_id;
        this.order_id = order_id;
        this.subject = subject;
        this.status = status;
        this.category = category;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
