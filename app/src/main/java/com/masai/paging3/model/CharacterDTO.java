package com.masai.paging3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CharacterDTO implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("species")
    private String species;

    @SerializedName("type")
    private String type;

    @SerializedName("gender")
    private String gender;

    @SerializedName("origin")
    private OriginDTO origin;

    @SerializedName("location")
    private LocationDTO location;

    @SerializedName("image")
    private String image;

    @SerializedName("episode")
    private List<String> episode;

    @SerializedName("url")
    private String url;

    @SerializedName("created")
    private String created;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public OriginDTO getOrigin() {
        return origin;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return
                "ResultsDTO{" +
                        "id = '" + id + '\'' +
                        ",name = '" + name + '\'' +
                        ",status = '" + status + '\'' +
                        ",species = '" + species + '\'' +
                        ",type = '" + type + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",origin = '" + origin + '\'' +
                        ",location = '" + location + '\'' +
                        ",image = '" + image + '\'' +
                        ",episode = '" + episode + '\'' +
                        ",url = '" + url + '\'' +
                        ",created = '" + created + '\'' +
                        "}";
    }
}