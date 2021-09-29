package com.masai.paging3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable {

    @SerializedName("info")
    private InfoDTO info;

    @SerializedName("results")
    private List<CharacterDTO> results;

    public InfoDTO getInfo() {
        return info;
    }

    public List<CharacterDTO> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "ResponseDTO{" +
                        "info = '" + info + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}