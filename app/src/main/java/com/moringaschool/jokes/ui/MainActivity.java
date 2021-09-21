package com.moringaschool.jokes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.jokes.Adapters.CategoryAdapter;
import com.moringaschool.jokes.R;
import com.moringaschool.jokes.fragments.Main;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    RecyclerView catList;
    List<String> categories ;
    CategoryAdapter adapter ;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = new ArrayList<>();
        // cat names
        categories.add("Any");
        categories.add("Programming");
        categories.add("Music");
        categories.add("Dark");
        categories.add("Pun");
        categories.add("Spooky");
        categories.add("Christmas");


        catList = findViewById(R.id.catlist);
        adapter = new CategoryAdapter(categories);
        catList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catList.setAdapter(adapter);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment_container, new Main());
        transaction.commit();
        }
    }