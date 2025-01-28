package org.example.model;

import java.sql.Date;

public class Reservation {
    private int id;
    private String carId;
    private String userLogin;
    private Date startDate;
    private Date endDate;
    private String status;

    public Reservation(String carId, String userLogin, Date startDate) {
        this.carId = carId;
        this.userLogin = userLogin;
        this.startDate = startDate;
    }

    public Reservation(int id, String carId, String status, String userLogin) {
        this.id = id;
        this.carId = carId;
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
