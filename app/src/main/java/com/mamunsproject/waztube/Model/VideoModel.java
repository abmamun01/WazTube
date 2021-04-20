package com.mamunsproject.waztube.Model;

public class VideoModel {

    String x,t,id;


    public VideoModel() {
    }


    public VideoModel(String x, String t, String id) {
        this.x = x;
        this.t = t;
        this.id = id;
    }


    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
