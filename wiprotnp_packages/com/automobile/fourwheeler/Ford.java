package com.automobile.fourwheeler;

import com.automobile.Vehicle;

public class Ford extends Vehicle {

    public String getModelName() {
        return "Ford EcoSport";
    }

    public String getRegistrationNumber() {
        return "AP39GH5678";
    }

    public String getOwnerName() {
        return "Priya";
    }

    public int getSpeed() {
        return 100;
    }

    public void tempControl() {
        System.out.println("Air Conditioner is ON");
    }
}