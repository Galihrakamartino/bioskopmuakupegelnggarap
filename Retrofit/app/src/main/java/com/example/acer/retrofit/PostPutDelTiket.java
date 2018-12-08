package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

public class PostPutDelTiket {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Tiket mTiket;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tiket getTiket() {
        return mTiket;
    }

    public void setTiket(Tiket tiket) {
        mTiket = tiket;
    }

}
