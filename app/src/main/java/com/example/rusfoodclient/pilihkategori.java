package com.example.rusfoodclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class pilihkategori extends AppCompatActivity {
    CardView makanan,minuman;
    private ArrayList<ModelProduct> getKudus = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihkategori);
        makanan = findViewById(R.id.makanan);
        minuman = findViewById(R.id.minuman);

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.get("https://guti.darkair.pw/api/product/food")
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                System.out.println(response + "resssss");
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject hasil = (JSONObject) response.getJSONObject(i);
                                        ModelProduct item = new ModelProduct();
                                        item.setJudul(hasil.getString("name"));
                                        item.setId(hasil.getInt("id"));
                                        item.setImage(hasil.getString("image"));
                                        item.setHarga(hasil.getString("rego"));
                                        item.setDeskripsi(hasil.getString("description"));
                                        System.out.println("sss" + hasil.getString("description"));

                                        getKudus.add(item);
                                        saveArray(getKudus,"p");
                                    }
                                    Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                                    System.out.println(getKudus.size() +" hhh");
                                    i.putExtra("files",  getKudus);
                                    startActivity(i);

                                }catch (JSONException e) {
                                    e.printStackTrace();

                                }


                            }
                            @Override
                            public void onError(ANError anError) {
                                System.out.println(anError+"vfbnm");
                            }
                        });


            }


        });
        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.get("https://guti.darkair.pw/api/product/drink")
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                System.out.println(response + "resssss");
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject hasil = (JSONObject) response.getJSONObject(i);
                                        ModelProduct item = new ModelProduct();
                                        item.setJudul(hasil.getString("name"));
                                        item.setId(hasil.getInt("id"));
                                        item.setImage(hasil.getString("image"));
                                        item.setHarga(hasil.getString("rego"));
                                        item.setDeskripsi(hasil.getString("description"));
                                        System.out.println("sss" + hasil.getString("description"));

                                        getKudus.add(item);
                                        saveArray(getKudus,"p");

                                    }
                                    Intent i = new Intent(getApplicationContext(), Menu_utama.class);
                                    System.out.println(getKudus.size() +" hhh");
                                    i.putExtra("files",  getKudus);
                                    startActivity(i);


                                }catch (JSONException e) {
                                    e.printStackTrace();

                                }


                            }
                            @Override
                            public void onError(ANError anError) {
                                System.out.println(anError+"vfbnm");
                            }
                        });


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


}

