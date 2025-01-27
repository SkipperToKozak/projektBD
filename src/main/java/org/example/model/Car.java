package org.example.model;

import java.time.LocalDate;

public class Car {
    private String id;
    private String brand;
    private String model;
    private int productionYear;
    private String color;
    private int seatAmount;
    private int horsePower;
    private int mileage;
    private boolean available;
    private String status;
    private LocalDate lastCarInspection;

    public Car(String id, String brand, String model, int productionYear, String color, int seatAmount, int horsePower, int mileage, LocalDate lastCarInspection) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
        this.seatAmount = seatAmount;
        this.horsePower = horsePower;
        this.mileage = mileage;
        this.available = true;
        this.status = "Zdolny do jazdy";
        this.lastCarInspection = lastCarInspection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public LocalDate getLastCarInspection() {
        return lastCarInspection;
    }

    public void setLastCarInspection(LocalDate lastCarInspection) {
        this.lastCarInspection = lastCarInspection;
    }
}
