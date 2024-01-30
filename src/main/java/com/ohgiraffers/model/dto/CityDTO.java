package com.ohgiraffers.model.dto;

public class CityDTO {
    private int cityId;
    private String name;
    private int countryId;
    private String lastUpdate;

    public CityDTO() {}

    public CityDTO(int cityId, String name, int countryId, String lastUpdate) {
        this.cityId = cityId;
        this.name = name;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "cityId=" + cityId +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
