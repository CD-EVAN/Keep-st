package com.example.keep_st.bean;

/**
 * Created by lenovo on 2017/9/22.
 */

public class Video {

    private String videoTile;

    private int imageId;

    public Video(String videoTile, int imageId) {
        this.videoTile = videoTile;
        this.imageId = imageId;
    }

    public String getVideoTile() {
        return videoTile;
    }


    public int getImageId() {
        return imageId;
    }


}
