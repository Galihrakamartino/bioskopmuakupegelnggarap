package com.example.acer.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarEditFilm extends AppCompatActivity {

    EditText edtIdFilm, edtjudul, edtgenre;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_edit_film);
        edtIdFilm = (EditText) findViewById(R.id.edtIdFilm);
        edtjudul = (EditText) findViewById(R.id.edtjudul);
        edtgenre = (EditText) findViewById(R.id.edtgenre);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);



        Intent mIntent = getIntent();
        edtIdFilm.setText(mIntent.getStringExtra("id_film"));
        edtjudul.setText(mIntent.getStringExtra("judul"));
        edtgenre.setText(mIntent.getStringExtra("genre"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelFilm> updateFilmCall = mApiInterface.putFilm(
                        edtIdFilm.getText().toString(),
                        edtjudul.getText().toString(),
                        edtgenre.getText().toString());

                updateFilmCall.enqueue(new Callback<PostPutDelFilm>() {
                    @Override
                    public void onResponse(Call<PostPutDelFilm> call, Response<PostPutDelFilm> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : " +response.body().getStatus() +
                                "\n " + " Message Update : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelFilm> call, Throwable t) {
                        tvMessage.setText("Retrofit Update: \n Status Update :"+ t.getMessage());
                    }
                });
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelFilm> postFilmCall = mApiInterface.postFilm(
                        edtIdFilm.getText().toString(),
                        edtjudul.getText().toString(),
                        edtgenre.getText().toString()
                        );

                postFilmCall.enqueue(new Callback<PostPutDelFilm>() {
                    @Override
                    public void onResponse(Call<PostPutDelFilm> call, Response<PostPutDelFilm> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : " +
                                response.body().getStatus() +
                                "\n " + " Message Insert : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelFilm> call, Throwable t) {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+ t.getMessage());
                    }
                });
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtIdFilm.getText().toString().trim().isEmpty()){

                    Call<PostPutDelFilm> deleteFilm = mApiInterface.deleteFilm(edtIdFilm.getText().toString());
                    deleteFilm.enqueue(new Callback<PostPutDelFilm>() {
                        @Override
                        public void onResponse(Call<PostPutDelFilm> call, Response<PostPutDelFilm> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : " +response.body().getStatus() +
                                    "\n " + " Message Delete : "+ response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<PostPutDelFilm> call, Throwable t) {
                            tvMessage.setText("Retrofit Delete: \n Status Delete :"+ t.getMessage());
                        }
                    });
                }else{
                    tvMessage.setText("id_film harus diisi");
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), LayarFilm.class);
                startActivity(mIntent);
            }
        });



                    }
}
