package com.example.displaylistcustomer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
    private String name;
    private LocalDate dateBorn;
    private String address;
    private String pathPicture;

    public Customer(String name, LocalDate dateBorn, String address, String pathPicture) {
        this.name = name;
        this.dateBorn = dateBorn;
        this.address = address;
        this.pathPicture = pathPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBorn() {
        return dateBorn.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPathPicture() {
        return pathPicture;
    }

    public void setPathPicture(String pathPicture) {
        this.pathPicture = pathPicture;
    }
}
