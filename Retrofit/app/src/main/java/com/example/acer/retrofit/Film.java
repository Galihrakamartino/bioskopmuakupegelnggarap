package com.example.acer.retrofit;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id_film")
    private String id_film;
    @SerializedName("judul")
    private String judul;
    @SerializedName("genre")
    private String genre;

    public Film(String id_film, String judul, String genre) {
        this.id_film = id_film;
        this.judul = judul;
        this.genre = genre;
    }

    public String getId_film() {
        return id_film;
    }

    public void setId_film(String id_film) {
        this.id_film = id_film;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
