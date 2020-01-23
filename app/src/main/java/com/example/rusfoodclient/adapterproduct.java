package com.example.rusfoodclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class adapterproduct extends RecyclerView.Adapter<adapterproduct.JadwalViewHolder>{

    private Context mContext;
    private ArrayList<ModelProduct> dataList;

    public adapterproduct(Context mContext, ArrayList<ModelProduct> dataList) {
        this.dataList = dataList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.listmenu, parent, false);
        return new JadwalViewHolder(view);
    }
    @Override
    public void onBindViewHolder(JadwalViewHolder holder, int position) {
        final ModelProduct surah = dataList.get(position);


        holder.title.setText(surah.getJudul());
        holder.harga.setText(surah.getHarga());
        Glide.with(holder.itemView.getContext())
                .load("https://guti.darkair.pw/"+surah.getImage())
                .into(holder.foto);
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
        private ImageView foto;

        public JadwalViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.judul);
            harga = (TextView) itemView.findViewById(R.id.harga);
            foto = (ImageView) itemView.findViewById(R.id.foto);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });
        }
    }
}
