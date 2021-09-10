package com.moringaschool.jokes;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyJokesArrayAdapter  extends ArrayAdapter {
    private Context mContext;
    private String [] mJokes;

    public MyJokesArrayAdapter(Context mContext, int resource, String [] mJokes){
        super(mContext, resource);
        this.mContext = mContext ;
        this.mJokes = mJokes ;
    }

@Override
    public Object getItem (int position){
        String jokes = mJokes[position];
        return String.format("%s \nServes great: %s",jokes);
}
@Override
    public int getCount(){
        return mJokes.length;
}
}
