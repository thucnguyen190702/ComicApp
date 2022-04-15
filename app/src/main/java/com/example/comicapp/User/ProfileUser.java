package com.example.comicapp.User;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.comicapp.Comic.ApiInterface;
import com.example.comicapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileUser extends Fragment {
    TextView txt_name,txt_email;
    Button btn_logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile,container,false);
//        txt_name = view.findViewById(R.id.txt_name);
//        txt_email = view.findViewById(R.id.txt_email);
//        btn_logout = view.findViewById(R.id.btn_logout);
//        String name = getArguments().getString("name");
//        String email = getArguments().getString("email");
//        txt_name.setText(name);
//        txt_email.setText(email);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.0.103:8080/apiUser/user/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<Users> call = apiInterface.getProfile();
//        call.enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//                Users users = response.body();
//                txt_name.setText(users.getUsername());
//                txt_email.setText(users.getEmail());
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//
//            }
//        });
        return view;
    }
}
