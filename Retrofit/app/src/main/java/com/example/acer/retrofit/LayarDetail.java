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

public class LayarDetail extends AppCompatActivity {
    EditText edtIdTiket, edtIdFilm, edtIdStudio, edtharga, edttayang;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail);
        edtIdTiket = (EditText) findViewById(R.id.edtIdTiket);
        edtIdFilm = (EditText) findViewById(R.id.edtIdFilm);
        edtIdStudio = (EditText) findViewById(R.id.edtIdStd);
        edtharga = (EditText) findViewById(R.id.edtharga);
        edttayang = (EditText) findViewById(R.id.edttayang);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);



        Intent mIntent = getIntent();
        edtIdTiket.setText(mIntent.getStringExtra("id_tiket"));
        edtIdFilm.setText(mIntent.getStringExtra("id_film"));
        edtIdStudio.setText(mIntent.getStringExtra("id_studio"));
        edtharga.setText(mIntent.getStringExtra("harga"));
        edttayang.setText(mIntent.getStringExtra("tayang"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelTiket> updateTiketCall = mApiInterface.putTiket(
                        edtIdTiket.getText().toString(),
                        edtIdFilm.getText().toString(),
                        edtIdStudio.getText().toString(),
                        edtharga.getText().toString(),
                        edttayang.getText().toString());

                updateTiketCall.enqueue(new Callback<PostPutDelTiket>() {
                    @Override
                    public void onResponse(Call<PostPutDelTiket> call, Response<PostPutDelTiket> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : " +response.body().getStatus() +
                                "\n " + " Message Update : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelTiket> call, Throwable t) {
                        tvMessage.setText("Retrofit Update: \n Status Update :"+ t.getMessage());
                    }
                });
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelTiket> postTiketCall = mApiInterface.postTiket(
                        edtIdTiket.getText().toString(),
                        edtIdFilm.getText().toString(),
                        edtIdStudio.getText().toString(),
                        edtharga.getText().toString(),
                        edttayang.getText().toString());

                postTiketCall.enqueue(new Callback<PostPutDelTiket>() {
                    @Override
                    public void onResponse(Call<PostPutDelTiket> call, Response<PostPutDelTiket> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : " +
                                response.body().getStatus() +
                                "\n " + " Message Insert : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelTiket> call, Throwable t) {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+ t.getMessage());
                    }
                });
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtIdTiket.getText().toString().trim().isEmpty()){

                    Call<PostPutDelTiket> deleteTiket = mApiInterface.deleteTiket(edtIdTiket.getText().toString());
                    deleteTiket.enqueue(new Callback<PostPutDelTiket>() {
                        @Override
                        public void onResponse(Call<PostPutDelTiket> call, Response<PostPutDelTiket> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : " +response.body().getStatus() +
                                    "\n " + " Message Delete : "+ response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<PostPutDelTiket> call, Throwable t) {
                            tvMessage.setText("Retrofit Delete: \n Status Delete :"+ t.getMessage());
                        }
                    });
                }else{
                    tvMessage.setText("id_pembelian harus diisi");
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);
            }
        });






    }
    }

