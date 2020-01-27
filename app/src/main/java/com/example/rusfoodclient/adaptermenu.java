package com.example.rusfoodclient;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adaptermenu extends RecyclerView.Adapter<adaptermenu.JadwalViewHolder>{

    private Context mContext;
    private ArrayList<ModelProduct> dataList;

    public adaptermenu(Context mContext, ArrayList<ModelProduct> dataList) {
        this.dataList = dataList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public adaptermenu.JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.addmenu2, parent, false);
        return new adaptermenu.JadwalViewHolder(view);
    }
    @Override
    public void onBindViewHolder(adaptermenu.JadwalViewHolder holder, int position) {
        final ModelProduct surah = dataList.get(position);


        holder.title.setText(surah.getJudul());
        holder.harga.setText(surah.getHarga());
        System.out.println(surah.getImage()+"ppp");



    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    public class JadwalViewHolder extends RecyclerView.ViewHolder {
        private TextView title,harga;


        public JadwalViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.namamakan);
            harga = (TextView) itemView.findViewById(R.id.hargaq);


        }
    }
}
