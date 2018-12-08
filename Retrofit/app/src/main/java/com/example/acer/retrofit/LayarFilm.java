package com.example.acer.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarFilm extends AppCompatActivity {
    Button btGet;
    ApiInterface mApiInterface;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_film);
        btGet = (Button) findViewById(R.id.btGet);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager =  new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetFilm> filmCall = mApiInterface.getFilm();
                filmCall.enqueue(new Callback<GetFilm>() {
                    @Override
                    public void onResponse(Call<GetFilm> call, Response<GetFilm> response) {
                        List<Film> filmList = response.body().getListDataFilm();
                        Log.d("Retrofit Get", "Jumlah data Film: " + String.valueOf(filmList.size()));
                        mAdapter = new FilmAdapter(filmList);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetFilm> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });


    }
}
