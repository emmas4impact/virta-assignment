package com.virta.api.applicationApi;

import com.virta.api.RestResource;
import com.virta.pojo.StationRequest;
import io.restassured.response.Response;

import static com.virta.api.Routes.TESTS;

public class StationAPI {

    public static Response post(StationRequest requestStation, String stationID){
        return RestResource.post(TESTS+stationID,requestStation);

    }

}
