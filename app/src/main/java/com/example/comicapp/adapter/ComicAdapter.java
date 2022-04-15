package com.example.comicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicapp.Comic.Comic;
import com.example.comicapp.Comic.DetailComic;
import com.example.comicapp.R;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.AdapterViewHolder> {
    Context context;
    List<Comic> listComic;

    public ComicAdapter(Context context, List<Comic> listComic) {
        this.context = context;
        this.listComic = listComic;
    }

    @NonNull
    @Override
    public ComicAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemgetdata, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicAdapter.AdapterViewHolder holder, int position) {
        Comic comics = listComic.get(position);
        if (comics == null) {
            return;
        }
        Glide.with(holder.img_avatar.getContext()).load(comics.getImage()).into(holder.img_avatar);
        holder.txt_name.setText(comics.getName());
        holder.cardViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailComic.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",comics.getName());
                bundle.putString("author",comics.getAuthor());
                bundle.putString("category",comics.getCategory());
                bundle.putString("image",comics.getImage());
                bundle.putString("content",comics.getContent());
                bundle.putStringArray("imagecontent",comics.getImagecontent());
                Log.e("TAG", "onClick: "+  comics.getImagecontent());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listComic.size();
    }
    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView img_avatar;
        TextView txt_name;
        CardView cardViewData;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            txt_name = itemView.findViewById(R.id.txt_name);
            cardViewData = itemView.findViewById(R.id.cardViewData);
        }
    }
}
