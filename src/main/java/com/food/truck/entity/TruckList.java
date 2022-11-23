package com.food.truck.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TruckList {

    List<Truck> trucks;

    public TruckList() {
        trucks = new ArrayList<>();
    }

    public TruckList(List<Truck> trucks) {
        this.trucks = trucks;
    }
}
