package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicapp.Comic.ApiInterface;
import com.example.comicapp.User.ProfileUser;
import com.example.comicapp.User.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    TextView moveRegister, ed_password, ed_user;
    Button btn_login;
    SharedPreferences preferences;
    CheckBox chk_Login;
    String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        moveRegister = findViewById(R.id.moveRegister);
        btn_login = findViewById(R.id.btn_login);
        ed_password = findViewById(R.id.ed_password);
        ed_user = findViewById(R.id.ed_user);
        chk_Login = findViewById(R.id.chk_Login);
        preferences =getSharedPreferences("rememberLogin",MODE_PRIVATE);
        ed_user.setText(preferences.getString("email",""));
        ed_password.setText(preferences.getString("password",""));
        chk_Login.setChecked(preferences.getBoolean("checked",false));
        moveRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (ed_user.getText().toString().trim().isEmpty() &&
                        ed_password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    postLogin(ed_user.getText().toString(), ed_password.getText().toString());
                    rememberUser(ed_user.getText().toString(),ed_password.getText().toString(),chk_Login.isChecked());
                }
            }
        });
    }
    private void rememberUser(String email ,String password,boolean checked) {
        SharedPreferences preferences = getSharedPreferences("rememberLogin",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (!checked){
            editor.clear();
        }else {
            editor.putString("email",email);
            editor.putString("password",password);
            editor.putBoolean("checked",checked);
        }
        editor.commit();
    }
    void postLogin(String email, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.47:8080/apiUser/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Users users = new Users(email,password);
        Call<Users> call = apiInterface.postLogin(users);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                try {
                    Users userApi = response.body();
                    token = userApi.getToken();
                    if (token != null) {
                        startActivity(new Intent(Login.this, MainActivity.class));
                    } else {
                        Toast.makeText(Login.this, "Login failed , Please check email or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(Login.this, "Login failed , Please check email or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }
}