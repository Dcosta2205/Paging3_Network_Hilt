package com.masai.paging3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LocationDTO implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "LocationDTO{" +
                        "name = '" + name + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}