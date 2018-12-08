package com.example.acer.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity
{
    EditText edtIdPembelian, edtIdPembeli, edtTanggalBeli, edtIdTiket, edtTotalHarga;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtIdPembelian = (EditText) findViewById(R.id.edtIdPembelian);
        edtIdPembeli = (EditText) findViewById(R.id.edtIdPembeli);
        edtTanggalBeli = (EditText) findViewById(R.id.edtTanggalBeli);
        edtIdTiket = (EditText) findViewById(R.id.edtIdTiket);
        edtTotalHarga = (EditText) findViewById(R.id.edtTotalHarga);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);

        Intent mIntent = getIntent();
        edtIdPembelian.setText(mIntent.getStringExtra("id_pembelian"));
        edtIdPembeli.setText(mIntent.getStringExtra("id_pembeli"));
        edtTanggalBeli.setText(mIntent.getStringExtra("tanggal_beli"));
        edtIdTiket.setText(mIntent.getStringExtra("id_tiket"));
        edtTotalHarga.setText(mIntent.getStringExtra("total_harga"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);


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





            default:
                return super.onOptionsItemSelected(item);
        }
    }

}