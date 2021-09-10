package com.moringaschool.jokes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

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
    }
}