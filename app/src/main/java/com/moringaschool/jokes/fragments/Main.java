package com.moringaschool.jokes.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.jokes.R;

public class Main extends Fragment {
    public static final String TAG = "TAG";
    String jokeApiUrl;
    RecyclerView jokesList;

    public Main(String url) {
        this.jokeApiUrl = url;
        Log.d(TAG,"Main :" +jokeApiUrl);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}