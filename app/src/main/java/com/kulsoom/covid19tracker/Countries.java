package com.kulsoom.covid19tracker;

import com.google.gson.annotations.SerializedName;

public class Countries {

    @SerializedName("Country")
    private String Country;

    @SerializedName("TotalConfirmed")
    private String totalCases;

    @SerializedName("NewConfirmed")
    private String newCases;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }
}
