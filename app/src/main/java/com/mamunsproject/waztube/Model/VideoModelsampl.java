package com.mamunsproject.waztube.Model;

public class VideoModelsampl {

    private Long id;
    private String videoId;

    public VideoModelsampl() {
    }


    public VideoModelsampl(Long id, String videoId) {
        this.id = id;
        this.videoId = videoId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
