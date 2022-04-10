package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class Register extends AppCompatActivity {
    EditText ed_username,ed_password,ed_repassword,ed_birth,ed_email,ed_phone;
    RadioButton rdo_female,rdo_male;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControll();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControll() {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        ed_repassword = findViewById(R.id.ed_repassword);
        ed_birth = findViewById(R.id.ed_birth);
        ed_email = findViewById(R.id.ed_email);
        ed_phone = findViewById(R.id.ed_phone);
        rdo_female = findViewById(R.id.rdo_female);
        rdo_male = findViewById(R.id.rdo_male);
    }
}