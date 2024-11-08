package com.example.as_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import entities.Meal;

public class mealsRecylclerAdapter extends RecyclerView.Adapter<mealsRecylclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<Meal> meals;
    RecyclerViewClickListener listener;
    public mealsRecylclerAdapter(Context context, ArrayList<Meal>meals,RecyclerViewClickListener listener) {
        this.meals=meals;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public mealsRecylclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_view,parent,false);
        return new mealsRecylclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mealsRecylclerAdapter.MyViewHolder holder, int position) {
        holder.remainPB.setProgress((int) (100*(float)(meals.get(position).getTakenCalories())/meals.get(position).getTotalCalories()));
        holder.mealNameTV.setText(meals.get(position).getName());
        holder.mealRemainTV.setText(meals.get(position).getTakenCalories()+"\\"+meals.get(position).getTotalCalories());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ProgressBar remainPB;
        TextView mealNameTV,mealRemainTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            remainPB=itemView.findViewById(R.id.mealRemainPB);
            mealNameTV=itemView.findViewById(R.id.mealNameTV);
            mealRemainTV=itemView.findViewById(R.id.mealRemainTV);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View view,int position);
    }
}
