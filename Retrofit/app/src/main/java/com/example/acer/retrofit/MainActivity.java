package com.example.acer.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btGet;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGet = (Button) findViewById(R.id.btGet);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetTiket> tiketCall = mApiInterface.getTiket();
                tiketCall.enqueue(new Callback<GetTiket>() {
                    @Override
                    public void onResponse(Call<GetTiket> call, Response<GetTiket> response) {
                        List<Tiket> tiketList = response.body().getListDataTiket();
                        Log.d("Retrofit Get", "Jumlah data tiket: " + String.valueOf(tiketList.size()));

                        mAdapter= new TiketAdapter(tiketList);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetTiket> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {


            case R.id.layarfilm:
                mIntent = new Intent(this, LayarFilm.class);
                startActivity(mIntent);
                return true;

            case R.id.layarutama:
                mIntent = new Intent(this, layarutama.class);
                startActivity(mIntent);
                return true;

            case R.id.menuListStudio:
                mIntent = new Intent(this, LayarListStudio.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertStudio:
                Intent mintent = new Intent(this, LayarInsertStudio.class);
                startActivity(mintent);
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


