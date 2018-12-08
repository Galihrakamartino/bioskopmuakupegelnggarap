package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

public class Tiket {
    @SerializedName("id_tiket")
    private String id_tiket;
    @SerializedName("id_film")
    private String id_film;
    @SerializedName("id_studio")
    private String id_studio;
    @SerializedName("harga")
    private int harga;
    @SerializedName("tayang")
    private String tayang;

    public Tiket(String id_tiket, String id_film, String id_studio, int harga, String tayang) {
        this.id_tiket = id_tiket;
        this.id_film = id_film;
        this.id_studio = id_studio;
        this.harga = harga;
        this.tayang = tayang;
    }

    public String getId_tiket() {
        return id_tiket;
    }

    public void setId_tiket(String id_tiket) {
        this.id_tiket = id_tiket;
    }

    public String getId_film() {
        return id_film;
    }

    public void setId_film(String id_film) {
        this.id_film = id_film;
    }

    public String getId_studio() {
        return id_studio;
    }

    public void setId_studio(String id_studio) {
        this.id_studio = id_studio;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getTayang() {
        return tayang;
    }

    public void setTayang(String tayang) {
        this.tayang = tayang;
    }
}
