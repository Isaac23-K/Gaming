package com.moringaschool.jokes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
//    @BindView(R.id.appNameTextView)
//    TextView mAppNameTextView ;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.btn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                b.startAnimation(animation);
            }
        });


        categories = new ArrayList<>();
        // cat names
        categories.add("Any");
        categories.add("Programming");
        categories.add("Misc");
        categories.add("Dark");
        categories.add("Pun");
        categories.add("Spooky");
        categories.add("Christmas");


        catList = findViewById(R.id.jokeCatList);
        adapter = new CategoryAdapter(categories);
        catList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catList.setAdapter(adapter);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment_frame, new Main( getResources().getString(R.string.Url)+"Any?amount=10"));
        transaction.commit();
        }
    }