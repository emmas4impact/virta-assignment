
package com.virta.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)


public class StationRequest {

    @JsonProperty("command")
    private String command;
    @JsonProperty("payload")
    private Integer payload;

    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("command")
    public StationRequest setCommand(String command) {
        this.command = command;
        return this;
    }

    @JsonProperty("payload")
    public Integer getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public StationRequest setPayload(Integer payload) {
        this.payload = payload;
        return this;
    }

}
