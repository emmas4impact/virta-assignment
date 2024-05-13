package com.virta.api;

import com.virta.pojo.StationRequest;
import io.restassured.response.Response;

import static com.virta.api.SpecBuilder.getRequestSpec;
import static com.virta.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object requestStation){

        return given(getRequestSpec())
                .body(requestStation).when().post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
