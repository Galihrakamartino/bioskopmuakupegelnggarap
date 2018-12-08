package com.example.acer.retrofit;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder>{
    List<Film> mFilmList;

    public FilmAdapter(List<Film> filmList) {
        mFilmList = filmList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdFilm.setText("Id Film :  " + mFilmList.get(position)
                .getId_film());
        holder.mTextViewjudul.setText("Judul :  " + mFilmList.get(position)
                .getJudul());
        holder.mTextViewgenre.setText("Genre :  " + mFilmList.get(position).getGenre
                ());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(view.getContext(), LayarEditFilm.class);
                mIntent.putExtra("id_film",mFilmList.get(position).getId_film());
                mIntent.putExtra("judul",mFilmList.get(position).getJudul());
                mIntent.putExtra("genre",mFilmList.get(position).getGenre());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFilmList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdFilm, mTextViewjudul, mTextViewgenre;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdFilm = (TextView) itemView.findViewById(R.id.tvIdFilmcontent);
            mTextViewjudul = (TextView) itemView.findViewById(R.id.tvjudulcontent);
            mTextViewgenre = (TextView) itemView.findViewById(R.id.tvgenre);
        }

    }

    }
