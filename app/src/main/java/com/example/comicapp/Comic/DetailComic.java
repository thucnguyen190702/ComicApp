package com.example.comicapp.Comic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicapp.R;

public class DetailComic extends AppCompatActivity {
    TextView namecomic,category,author,content;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comic);
        namecomic = findViewById(R.id.namecomic);
        category = findViewById(R.id.category);
        author = findViewById(R.id.author);
        content = findViewById(R.id.content);
        imageView = findViewById(R.id.img_detail_avatar);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!=null) {
            namecomic.setText("Tên truyện : " + bundle.getString("name"));
            author.setText("-Tác giả: " + bundle.getString("author"));
            category.setText("-Thể loại: " + bundle.getString("category"));
            String img = bundle.getString("image");
            Glide.with(imageView.getContext()).load(img).into(imageView);
            content.setText(bundle.getString("content"));
        }
    }
}