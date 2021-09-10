package com.moringaschool.jokes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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
    }
}