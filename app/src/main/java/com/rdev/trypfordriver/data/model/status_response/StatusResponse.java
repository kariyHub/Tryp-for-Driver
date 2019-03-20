package com.rdev.trypfordriver.data.model.status_response;

import com.google.gson.annotations.SerializedName;

public class StatusResponse {

    @SerializedName("data")
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return
                "StatusResponse{" +
                        "data = '" + data + '\'' +
                        "}";
    }
}