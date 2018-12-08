package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTiket {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Tiket> listDataTiket;
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

    public List<Tiket> getListDataTiket() {
        return listDataTiket;
    }

    public void setListDataTiket(List<Tiket> listDataTiket) {
        this.listDataTiket = listDataTiket;
    }


}
