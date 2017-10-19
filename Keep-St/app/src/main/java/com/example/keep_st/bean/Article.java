package com.example.keep_st.bean;

/**
 * Created by lenovo on 2017/9/21.
 */

public class Article {

    private String articleTile;

    private int imageId;

    private String articleType;

    private int contentId;

    public Article(String articleTile, int imageId,String articleType,int contentId) {
        this.articleTile = articleTile;
        this.imageId = imageId;
        this.articleType = articleType;
        this.contentId = contentId;

    }

    public int getImageId() {
        return imageId;
    }

    public String getArticleTile() {
        return articleTile;
    }

    public String getArticleType() {
        return articleType;
    }

    public int getContentId() {
        return contentId;
    }
}
