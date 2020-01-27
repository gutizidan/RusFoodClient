package com.example.rusfoodclient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.Preferences;

public class detail extends AppCompatActivity {
    ImageView imageView;
    TextView angka,desk;
    Button book,plus,minus;
    ArrayList<ModelProduct> getKudus1;

    SharedPreferences shared;
    private int i;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imageview);
        angka = findViewById(R.id.angkaa);
        desk = findViewById(R.id.desk);
        book = findViewById(R.id.bookbtn);
        plus = findViewById(R.id.pluss);
        minus = findViewById(R.id.mnus);
        angka.setText(String.valueOf(i));




        shared = getSharedPreferences("App_settings", MODE_PRIVATE);
        // add values for your ArrayList any where...

        getKudus1 = new ArrayList<>();
        ModelProduct modelProduct = new ModelProduct();
        modelProduct.setId(getIntent().getIntExtra("files3",0));
        modelProduct.setJudul(getIntent().getStringExtra("files4"));
        modelProduct.setHarga(getIntent().getStringExtra("files5"));
        getKudus1.add(modelProduct);
        saveArray(getKudus1 ,"pp");
//        ModelProduct modelProduct = getKudus1.get(0);


//        desk.setText(getIntent().getStringExtra("files1"));
        desk.setText(getIntent().getStringExtra("files1"));
        Glide.with(getApplicationContext())
                .load("https://guti.darkair.pw/"+getIntent().getStringExtra("files2"))
                .into(imageView);






        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusea();
                angka.setText(String.valueOf(i));
            }
        });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if (i>0){
                        minusea();
                    angka.setText(String.valueOf(i));}
                    else if (i<=0){
                        Toast.makeText(getApplicationContext(), "Masukan jumlah", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), addmenu.class);
//                    i.putExtra("arraybro",  getKudus1);
                    startActivity(i);
                }
            });
        }
    public void saveArray(ArrayList<ModelProduct> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }
    public ArrayList<ModelProduct> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<ModelProduct>>() {}.getType();
        return gson.fromJson(json, type);
    }

public int plusea(){
        int hs = i++;
        hs = i;
        return i;
}
    public int minusea(){
        int hs = i--;
        hs = i;
        return i;
    }


    }


