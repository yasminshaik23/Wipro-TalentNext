package com.automobile.fourwheeler;

import com.automobile.Vehicle;

public class Logan extends Vehicle {

    public String getModelName() {
        return "Mahindra Logan";
    }

    public String getRegistrationNumber() {
        return "AP39EF1234";
    }

    public String getOwnerName() {
        return "Rahul";
    }

    public int getSpeed() {
        return 90;
    }

    public void gps() {
        System.out.println("GPS is ON");
    }
}