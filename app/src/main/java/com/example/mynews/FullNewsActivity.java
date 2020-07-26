package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);
        TextView news=findViewById(R.id.full_news);
        ImageView imageView=findViewById(R.id.image);


        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        NewsData d= (NewsData) data.getSerializable("fullNews");

        news.setText(d.getNewsData());
        getSupportActionBar().setTitle(d.getNewsSource());
        Picasso.get().load(d.getNewsImage()).into(imageView);
    }
}
