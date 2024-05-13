package com.virta.test;

import com.virta.api.applicationApi.StationAPI;
import com.virta.pojo.StationRequest;

import com.virta.pojo.StationResponse;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StationTest {

    @Test
    public void ShouldBeAbleToGetVersion(){
        StationRequest requestVersion = new StationRequest()
                .setCommand("getVersion")
                .setPayload(10);
        Response response = StationAPI.post( requestVersion,"1");
        assertThat(response.statusCode(), equalTo(200));

        //deserialization
        StationResponse stationResponse =response.as(StationResponse.class);
        assertThat(stationResponse.getResult(), equalTo("1.5"));
    }
    @Test
    public void ShouldBeAbleToGetInterval(){
        StationRequest requestInterval = new StationRequest()
                .setCommand("getInterval")
                .setPayload(1);

        Response response = StationAPI.post( requestInterval,"1");
        assertThat(response.statusCode(), equalTo(200));
        //deserialization
        StationResponse stationResponse = response.as(StationResponse.class);
        assertThat(stationResponse.getResult(), equalTo("0"));

    }
    @Test
    public void ShouldBeAbleToSetValue(){
        StationRequest requestValues= new StationRequest()
                .setCommand("setValues")
                .setPayload(1);
        Response response = StationAPI.post( requestValues,"1");
        assertThat(response.statusCode(), equalTo(200));
        //deserialization
        StationResponse stationResponse = response.as(StationResponse.class);
        assertThat(stationResponse.getResult(), equalTo("FAILED"));

    }
}
