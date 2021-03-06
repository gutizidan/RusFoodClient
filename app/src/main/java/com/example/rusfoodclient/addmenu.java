package com.example.rusfoodclient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class addmenu extends AppCompatActivity {
    private RecyclerView rvSurah;
    private adaptermenu allLeaguesAdapter;
    ArrayList<ModelProduct> getKudus10 = new ArrayList<>();
    CardView add,next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmenu);
        rvSurah = findViewById(R.id.recycler);
//        getKudus1 = (ArrayList<ModelProduct>) getIntent().getSerializableExtra("arraybro");
//                        saveArray(getKudus1,"pp");


        getKudus10 = getArrayList("pp");




        add = findViewById(R.id.addmenu);
        next = findViewById(R.id.nexttocheck);

        System.out.println(getKudus10.size() + "dfgh");
        System.out.println(getArrayList("pp").size() + "dfagh");

        setup();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                startActivity(i);
//                saveArray(getKudus10,"pp");
            }
        });

    }
    private void setup(){ allLeaguesAdapter = new adaptermenu(this, getKudus10);
        rvSurah.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvSurah.setHasFixedSize(true);
        rvSurah.setAdapter(allLeaguesAdapter);}
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Anda yakin?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        getKudus10.clear();

                        Intent i = new Intent(getApplicationContext(), pilihkategori.class);
                        startActivity(i);                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();

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
    }




