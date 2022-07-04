package org.example10.models;

public class DayBusiness {
private int id_day;
    private float productsPerDay;
    private float averageTime;

    public DayBusiness() {

    }


    public DayBusiness(int id_day, float productsPerDay) {
        this.id_day = id_day;
        this.productsPerDay = productsPerDay;
        this.averageTime = productsPerDay/8;
    }
    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }
    public float getProductsPerDay() {
        return productsPerDay;
    }

    public void setProductsPerDay(float productsPerDay) {
        this.productsPerDay = productsPerDay;
    }

    public float getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(float averageTime) {
        this.averageTime = averageTime;
    }
}
