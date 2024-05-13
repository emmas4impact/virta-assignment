package com.virta.stepDefinitions;
import com.virta.api.applicationApi.StationAPI;
import io.qameta.allure.Allure;
import com.virta.pojo.StationRequest;
import com.virta.pojo.StationResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static com.virta.api.Routes.BASE_PATH;
import static com.virta.api.Routes.TESTS;

public class MyStepdefs {
    private static final String BASE_URL ="https://api-energy-k8s.test.virtaglobal.com/" ;
    RequestSpecification request;
    private  static Response response;

    @Given("I hit the url of post station api endpoint")
    public void iHitTheUrlOfPostStationApiEndpoint() {
        RestAssured.baseURI  =  BASE_URL;
        request  =  RestAssured.given();
        request.header("Content-Type",  "application/json");
    }
    @When("I pass the {string} to endpoint and {string} to payload")
    public void iPassTheToEndpointAndToPayload(String stationId, String command) {
        StationRequest requestVersion = new StationRequest()
                .setCommand(command);
       response = StationAPI.post( requestVersion,stationId);

    }

    @Then("I receive response code {int}")
    public void iReceiveResponseCodeCode(int status_code) {
        Assert.assertEquals(status_code, response.getStatusCode());

    }

    @And("I see the {string} as {string}")
    public void iSeeTheAs(String field, String expectedValue) {
        if (!field.equals("-")) {
            RestAssured.defaultParser = Parser.JSON;
            StationResponse stationResponse = response.as(StationResponse.class);

            String actualValue;
            switch (field) {
                case "result":
                    actualValue = stationResponse.getResult();
                    break;

                default:
                    throw new IllegalArgumentException("Unknown field: " + field);
            }
            Assert.assertEquals(expectedValue, actualValue);
        }

    }


}
