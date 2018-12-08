package com.example.acer.retrofit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.MyViewHolder> {
    List<Tiket> mTiketList;

    public TiketAdapter(List<Tiket> tiketList) {
        mTiketList = tiketList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.mTextViewIdTiket.setText("Id Tiket :  " + mTiketList.get(position)
                .getId_tiket());
        holder.mTextViewIdfilm.setText("Id film :  " + mTiketList.get(position)
                .getId_film());
        holder.mTextViewIdstudio.setText("Id_studio :  " + mTiketList.get(position)
                .getId_studio());
        holder.mTextViewharga.setText("Harga :  " + mTiketList.get(position)
                .getHarga());
        holder.mTextViewtayang.setText("Total Harga :  " + String.valueOf(mTiketList.get
                (position).getHarga()));

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(view.getContext(), LayarDetail.class);
                mIntent.putExtra("id_tiket",mTiketList.get(position).getId_tiket());
                mIntent.putExtra("id_film",mTiketList.get(position).getId_tiket());
                mIntent.putExtra("id_studio",mTiketList.get(position).getId_studio());
                mIntent.putExtra("harga",mTiketList.get(position).getHarga());
                mIntent.putExtra("tayang",mTiketList.get(position).getTayang());
                view.getContext().startActivity(mIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mTiketList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdTiket, mTextViewIdfilm, mTextViewIdstudio, mTextViewharga, mTextViewtayang;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdTiket = (TextView) itemView.findViewById(R.id.tvIdTiket);
            mTextViewIdfilm = (TextView) itemView.findViewById(R.id.tvIdFilm);
            mTextViewIdstudio = (TextView) itemView.findViewById(R.id.tvIdStd);
            mTextViewharga = (TextView) itemView.findViewById(R.id.tvharga);
            mTextViewtayang = (TextView) itemView.findViewById(R.id.tvtayang);
        }

    }
}
