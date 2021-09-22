package com.moringaschool.jokes.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.moringaschool.jokes.Adapters.JokeAdapter;
import com.moringaschool.jokes.R;
import com.moringaschool.jokes.model.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main extends Fragment {
    public static final String TAG = "TAG";
    String jokeApiUrl;
    RecyclerView jokesList;
    JokeAdapter adapter ;
    List<Joke> allJokes;

    public Main(String url) {
        this.jokeApiUrl = url;
        Log.d(TAG,"Main :" +jokeApiUrl);
        allJokes = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        jokesList = v.findViewById(R.id.jokelist);
        jokesList.setLayoutManager(new LinearLayoutManager(v.getContext()));

        getJokes(jokeApiUrl);
        adapter = new JokeAdapter(allJokes);
        jokesList.setAdapter(adapter);
        return v;
    }

    public void getJokes(String url) {
        // extract json data

        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // Log.d(TAG, "onResponse: "+response.toString());
                try {
                    int amount = Integer.parseInt(response.getString("amount"));
                    JSONArray jokesArray = response.getJSONArray("jokes");
                     for (int i = 0 ; i < amount; i++){
                            JSONObject jokes = jokesArray.getJSONObject(i);
                        // Log.d(TAG, "onResponse: "+ jokes.getString("type"));
                         Joke j = new Joke();
                         j.setType(jokes.getString("type"));
                         if (jokes.getString("type").equals("single")){
                             j.setJoke(jokes.getString("joke"));

                         }   else {
                             j.setSetup(jokes.getString("setup"));
                             j.setDelivery(jokes.getString("delivery"));

                         }

                         allJokes.add(j);
                         adapter.notifyDataSetChanged();
                     }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(objectRequest);
    }
}