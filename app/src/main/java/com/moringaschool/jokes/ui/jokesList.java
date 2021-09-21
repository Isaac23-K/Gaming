package com.moringaschool.jokes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.jokes.MyJokesArrayAdapter;
import com.moringaschool.jokes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class jokesList extends AppCompatActivity {
    @BindView(R.id.jokesTextView)
    TextView mjokesTextView ;
    @BindView(R.id.listView)
    ListView mListView ;

    private String[] jokes = new String[]{"Did you hear about the mathematician who’s afraid of negative numbers?\n" +
            "He’ll stop at nothing to avoid them.", "Helvetica and Times New Roman walk into a bar.\n" +
            "“Get out of here!” shouts the bartender. “We don’t serve your type.”", "What do you call a boomerang that won’t come back?\n" +
            "A stick.", "What time is it when the clock strikes 13?\n" +
            "Time to get a new clock."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);
        ButterKnife.bind(this);

        MyJokesArrayAdapter adapter = new MyJokesArrayAdapter(this, android.R.layout.simple_list_item_1,jokes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String jokes = ((TextView)view).getText().toString();
                Toast.makeText(jokesList.this,jokes,Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String jokes = intent.getStringExtra("jokes");
        mjokesTextView.setText("Here are the type of jokes "+jokes);
    }
}