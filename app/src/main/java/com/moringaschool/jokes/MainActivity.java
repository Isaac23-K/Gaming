package com.moringaschool.jokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.findJokesButton)
    Button mFindJokesButton ;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView ;
    @BindView(R.id.typeEditText)
    EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindJokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this,jokesList.class);
                intent.putExtra("jokes", type);
            }
        });
    }
}