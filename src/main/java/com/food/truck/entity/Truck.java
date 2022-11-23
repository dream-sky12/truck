package com.food.truck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truck {
    String objectId;
    String applicant;
    String facilityType;
    String cnn;
    String locationDescription;
    String address;
    String blockLot;
    String permit;
    String status;
    String x;
    String y;
    String latitude;
    String longitude;
    String schedule;
}
