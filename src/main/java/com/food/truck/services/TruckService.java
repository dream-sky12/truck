package com.food.truck.services;

import com.food.truck.context.TruckDataContext;
import com.food.truck.entity.Truck;
import com.food.truck.entity.TruckList;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckService {

    public TruckList getAllTrucks() {
        List<Truck> trucks = TruckDataContext.getTrucks();
        return new TruckList(trucks);
    }

    public Truck getTruckById(String id) {
        List<Truck> allTrucks = TruckDataContext.getTrucks();
        return allTrucks.stream()
                .filter(target -> id.equals(target.getObjectId()))
                .findFirst()
                .orElse(null);
    }
    public TruckList getTrucksByApplicant(String applicant) {

        List<Truck> allTrucks = TruckDataContext.getTrucks();
        List<Truck> trucks = allTrucks.stream()
                .filter(truck -> applicant.equals(truck.getApplicant()))
                .collect(Collectors.toList());
        return new TruckList(trucks);
    }

    public TruckList getTrucksByType(String type) {
        List<Truck> allTrucks = TruckDataContext.getTrucks();
        List<Truck> trucks = allTrucks.stream()
                .filter(truck -> type.equals(truck.getFacilityType()))
                .collect(Collectors.toList());
        return new TruckList(trucks);
    }

    public TruckList getTrucksByStatus(String status) {
        List<Truck> allTrucks = TruckDataContext.getTrucks();
        List<Truck> trucks = allTrucks.stream()
                .filter(truck -> status.equals(truck.getStatus()))
                .collect(Collectors.toList());
        return new TruckList(trucks);
    }
}
