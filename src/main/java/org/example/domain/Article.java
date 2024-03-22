package org.example.domain;

public class Article {
    private int id;
    private String title;
    private String body;
    private int hit;
    private String date;

    public Article(){}
    public Article(int id, String title, String body, int hit, String date){
        this.id = id;
        this.title = title;
        this.body = body;
        this.hit = hit;
        this.date = date;
    }
    public void inHit(){
        this.hit++;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
