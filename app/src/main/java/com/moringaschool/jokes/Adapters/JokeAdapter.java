package com.moringaschool.jokes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.jokes.R;
import com.moringaschool.jokes.model.Joke;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {
    List<Joke> allJokes ;

    public JokeAdapter(List<Joke>jokes){
        this.allJokes = jokes ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokes_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeAdapter.ViewHolder holder, int position) {
        // check joke type
        if (allJokes.get(position).getType().equals("single")){
            holder.firsLine.setText(allJokes.get(position).getJoke());
            holder.secondLine.setText("");
        } else {
            holder.firsLine.setText(allJokes.get(position).getSetup());
            holder.secondLine.setText(allJokes.get(position).getDelivery());
        }
    }

    @Override
    public int getItemCount() {
        return allJokes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView firsLine , secondLine ;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            firsLine = itemView.findViewById(R.id.firstLine);
            secondLine = itemView.findViewById(R.id.secondLine);
        }
    }
}
