package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicapp.Comic.ApiInterface;
import com.example.comicapp.Comic.Comic;
import com.example.comicapp.Comic.GetDataComic;
import com.example.comicapp.User.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    TextView moveRegister, ed_password, ed_user;
    Button btn_login;
    List<Users> list = new ArrayList<>();
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        moveRegister = findViewById(R.id.moveRegister);
        btn_login = findViewById(R.id.btn_login);
        ed_password = findViewById(R.id.ed_password);
        ed_user = findViewById(R.id.ed_user);
        moveRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equalsIgnoreCase(ed_user.getText().toString()) == true &&
                            list.get(i).getPassword().equalsIgnoreCase(ed_password.getText().toString()) == true) {
                        Toast.makeText(Login.this, "Login thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, GetDataComic.class));
                    }else {
                        Toast.makeText(Login.this, "Login failed ,Please check", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.100:8080/apiUser/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Users>> call = apiInterface.getListUser();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    list.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(Login.this, "Loi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
}