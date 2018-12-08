package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetFilm {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Film> listDataFilm;
    @SerializedName("message")
    String message;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Film> getListDataFilm() {
        return listDataFilm;
    }

    public void setListDataFilm(List<Film> listDataFilm) {
        this.listDataFilm = listDataFilm;
    }


}
