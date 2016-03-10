package com.quickshop.data;

/**
 * Created by user on 07/03/2016.
 */
public class RecommendationData {

    private String message;
    private String imageURL;

    public RecommendationData(String message,String image) {
        this.message = message;
        this.imageURL = image;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMessage() {
        return message;
    }



}