package com.fae.recyclerview;

/**
 * Created by Luscas on 15/06/2017.
 */

public class Item {

    private String title;
    private String subTitle;

    public Item(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

}
