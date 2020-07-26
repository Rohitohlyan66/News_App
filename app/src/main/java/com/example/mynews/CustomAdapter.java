package com.example.mynews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<NewsData> data;
    Context context;

    public CustomAdapter(List<NewsData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        NewsData myData=data.get(position);
        holder.newsTitle.setText(myData.getNewsTitle());
        holder.newsSource.setText(myData.getNewsSource());
        holder.newsDate.setText(myData.getNewsDate());
        Picasso.get().load(data.get(position).getNewsImage()).into(holder.newsImage);

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putSerializable("fullNews",data.get(position));
                Intent intent=new Intent(context,FullNewsActivity.class);
                intent.putExtras(b);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitle,newsSource,newsDate;
        ImageView newsImage;
        View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle=itemView.findViewById(R.id.news_title);
            newsSource=itemView.findViewById(R.id.news_source);
            newsDate=itemView.findViewById(R.id.news_date);
            newsImage=itemView.findViewById(R.id.news_image);
            v=itemView;
        }
    }
}
