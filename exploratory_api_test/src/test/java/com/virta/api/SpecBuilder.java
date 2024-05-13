package com.virta.api;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



import static com.virta.api.Routes.BASE_PATH;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
        return  new RequestSpecBuilder()
                .setBaseUri("https://api-energy-k8s.test.virtaglobal.com")
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL).build();


    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

    }
}
