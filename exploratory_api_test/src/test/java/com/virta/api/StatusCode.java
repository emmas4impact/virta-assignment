package com.virta.api;

public enum StatusCode {
    CODE_200(200, "OK"),
    CODE_500(500,"Server Error"),
    CODE_400(400,"Missing required field: name"),
    CODE_404(404, "NOT FOUND");

    public final int code;
    public final String msg;
    StatusCode(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

}
