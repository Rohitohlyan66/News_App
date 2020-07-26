package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NewsData> list;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomAdapter(list,this);
        recyclerView.setAdapter(adapter);


        fetchData();
    }

    private void fetchData() {
        String url="http://newsapi.org/v2/top-headlines?country=in&apiKey=94a1d4b29ded44c3897f13ebb984234a";

      final RequestQueue requestQueue=Volley.newRequestQueue(this);
       final JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
   //            Log.d("Tag", "onResponse"+response);

               try {
                   JSONArray array=response.getJSONArray("articles");
    //               Log.d("Tag","onResponse"+array);

                   for (int i=0;i<array.length();i++)
                   {
                       JSONObject news=array.getJSONObject(i);
                        NewsData data=new NewsData();
                        data.setNewsTitle(news.getString("title"));
                        data.setNewsSource(news.getString("author"));
                        data.setNewsImage(news.getString("urlToImage"));
                        data.setNewsDate(news.getString("publishedAt"));
                        data.setNewsData(news.getString("description"));
                        list.add(data);
                        adapter.notifyDataSetChanged();
                   }


               } catch (JSONException e) {
                   e.printStackTrace();
               }


           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
requestQueue.add(objectRequest);
    }
}
