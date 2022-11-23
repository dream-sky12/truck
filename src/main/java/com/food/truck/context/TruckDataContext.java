package com.food.truck.context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.food.truck.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TruckDataContext {
    private static RestTemplate restTemplate;

    private static final String RESOURCE_URL = "https://data.sfgov.org/resource/rqzj-sfat.json";

    private static final List<Truck> trucks = new ArrayList<>();

    @Autowired
    public TruckDataContext(RestTemplate restTemplate) {
        TruckDataContext.restTemplate = restTemplate;
        initData();
    }
    private void initData() {
        try {
            String result = restTemplate.getForObject(RESOURCE_URL, String.class);
            JSONArray jsonArray = JSONObject.parseArray(result);
            if (jsonArray != null) {
                for (int index = 0; index < jsonArray.size(); index++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    Truck truck = new Truck(
                            jsonObject.getString("objectid"),
                            jsonObject.getString("applicant"),
                            jsonObject.getString("facilitytype"),
                            jsonObject.getString("cnn"),
                            jsonObject.getString("locationdescription"),
                            jsonObject.getString("address"),
                            jsonObject.getString("blocklot"),
                            jsonObject.getString("permit"),
                            jsonObject.getString("status"),
                            jsonObject.getString("x"),
                            jsonObject.getString("y"),
                            jsonObject.getString("latitude"),
                            jsonObject.getString("longitude"),
                            jsonObject.getString("schedule")
                    );
                    trucks.add(truck);
                }
            }
        } catch (Error e) {
            log.error("Failed in fetching source data of food trucks." + e.getMessage());
        }
    }
    public static List<Truck> getTrucks(){
        return trucks;
    }
}
