package com.masai.paging3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InfoDTO implements Serializable {

    @SerializedName("count")
    private int count;

    @SerializedName("pages")
    private int pages;

    @SerializedName("next")
    private String next;

    @SerializedName("prev")
    private String prev;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public String getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return
                "InfoDTO{" +
                        "count = '" + count + '\'' +
                        ",pages = '" + pages + '\'' +
                        ",next = '" + next + '\'' +
                        ",prev = '" + prev + '\'' +
                        "}";
    }
}