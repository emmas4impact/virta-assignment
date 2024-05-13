
package com.virta.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationResponse {

    @JsonProperty("result")
    private String result;

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

}
