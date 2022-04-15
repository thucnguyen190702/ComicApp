package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.comicapp.Comic.ApiInterface;
import com.example.comicapp.User.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {
    EditText ed_username, ed_password, ed_repassword, ed_email;

    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControll();
        addEvent();
    }

    private void addEvent() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_username.getText().toString().isEmpty() && ed_password.getText().toString().isEmpty() &&
                     ed_email.getText().toString().isEmpty() && ed_repassword.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    postData(ed_username.getText().toString(),ed_password.getText().toString(),
                            ed_email.getText().toString());

                }
                Log.e("TAG", "onClick: " + ed_username.getText().toString() );

            }
        });
    }

    private void postData(String username,String password,String email){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.47:8080/apiUser/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Users users = new Users(username,password,email);

        Call<List<Users>> call = apiInterface.postReg(users);

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                startActivity(new Intent(Register.this,Login.class));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(Register.this, "Register Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addControll() {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        ed_repassword = findViewById(R.id.ed_repassword);
        ed_email = findViewById(R.id.ed_email);
        btn_register = findViewById(R.id.btn_register);
    }
}