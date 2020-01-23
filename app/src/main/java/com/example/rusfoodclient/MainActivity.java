package com.example.rusfoodclient;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.Namalog);
        pass = findViewById(R.id.Passlog);
        login = findViewById(R.id.Buttonloog);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.post("https://guti.darkair.pw/api/login")
                        .addBodyParameter("email", user.getText().toString().trim())
                        .addBodyParameter("password", pass.getText().toString().trim())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String respon = response.getString("success");
                                    System.out.println("res " + respon);
//                                    System.out.println("Sukses " + suksess);
                                    if (respon.equalsIgnoreCase("true")) {
                                        Toast.makeText(getApplicationContext(), " Sukses Login", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(), pilihkategori.class);
                                        startActivity(i);
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), "User/Password Salah", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                // do anything with response
                            }
                            @Override
                            public void onError(ANError error) {
                                // handle error
                                System.out.println(error + "blbal");
                                Toast.makeText(getApplicationContext(), "User/Password Salah", Toast.LENGTH_SHORT).show();
                                user.setError("User/Password Salah");
                                pass.setError("User/Password Salah");

                            }
                        });

            }
        });

    }
}
