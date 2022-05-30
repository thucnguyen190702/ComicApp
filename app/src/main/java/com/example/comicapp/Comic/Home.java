package com.example.comicapp.Comic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.comicapp.R;
import com.example.comicapp.adapter.ComicAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends Fragment {
    RecyclerView recyclerView;
    List<Comic> list;
    ComicAdapter adapter;
//    List<String> listAnh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_get_data_comic, container, false);
        recyclerView = view.findViewById(R.id.recycleview);
        list = new ArrayList<>();
//        listAnh=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ComicAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.102:8080/apiComic/truyen/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Comic>> call = apiInterface.getComics();
        call.enqueue(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    list.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {

            }
        });

        return view;
    }
}
//    String url = "http://192.168.43.47:8080/apiComic/truyen/";
//    StringRequest request = new StringRequest(url, new Response.Listener<String>() {
//        @Override
//        public void onResponse(String response) {
//
//            try {
//                JSONArray jsonArray = new JSONArray(response);
//                JSONObject object = jsonArray.getJSONObject(0);
////                    String id = object.getString("_id");
//                String name = object.getString("name");
//                String author = object.getString("author");
//                String category = object.getString("category");
//                String image = object.getString("image");
//                String content = object.getString("content");
//                JSONArray jsonArrayAnh = object.getJSONArray("imagecontent");
//                for (int i = 0; i < jsonArrayAnh.length(); i++) {
//                    listAnh.add(jsonArrayAnh.getString(i));
//                }
//                Comic comic = new Comic(name,author,category,image,content);
//                list.addAll(comic);
//                Log.d("TAG", "onResponse: "+list.size());
//                adapter.notifyDataSetChanged();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//
//        }
//    });