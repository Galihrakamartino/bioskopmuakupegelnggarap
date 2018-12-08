package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

public class PostPutDelFilm {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Film mFilm;
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

    public Film getFilm() {
        return mFilm;
    }

    public void setFilm(Film film) {
        mFilm = film;
    }

}
