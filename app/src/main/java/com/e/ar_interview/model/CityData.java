package com.e.ar_interview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private List<CityDetailsItem> rows = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CityDetailsItem> getRows() {
        return rows;
    }

    public void setRows(List<CityDetailsItem> rows) {
        this.rows = rows;


    }
}
