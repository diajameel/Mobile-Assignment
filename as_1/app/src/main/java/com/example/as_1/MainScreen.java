package com.example.as_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import entities.Day;
import entities.FoodSrc;
import entities.Meal;
import entities.MealFood;

public class MainScreen extends AppCompatActivity {

    TextView remainCalTV;
    TextView carbsTV;
    TextView proteinTV;
    TextView fatTV;
    ProgressBar remainPB;
    ProgressBar carbsPB;
    ProgressBar proteinPB;
    ProgressBar fatPB;
    public static Day day;
    public static ArrayList<Meal> reCyclerMeals;
    RecyclerView MealsRecycler;
    mealsRecylclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_screen);
        attributeInitiate();
        mealsReCyclerListener();
        mealsReCyclerAdapterInitiate();
        macronutrientTVAndPBHandle();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("user","name:"+signUp.user.getName()+",age:"+signUp.user.getAge()+",weight:"+signUp.user.getWeight()
                +",length:"+signUp.user.getLength()+",sex:"+signUp.user.getSex()+",goal:"+signUp.user.getGoal()+
                ",nutrition:"+signUp.user.getNutrition()+",activity:"+signUp.user.getActivityLevel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        day.setBreakfast(reCyclerMeals.get(0));
        day.setLaunch(reCyclerMeals.get(1));
        day.setDinner(reCyclerMeals.get(2));
        day.setSnack(reCyclerMeals.get(3));
        mealsReCyclerAdapterInitiate();
        mealsReCyclerListener();
        macronutrientTVAndPBHandle();
    }

    public void mealsReCyclerAdapterInitiate(){
        mealsRecylclerAdapter recylclerAdapter=new mealsRecylclerAdapter(this,reCyclerMeals,listener);
        MealsRecycler.setAdapter(recylclerAdapter);
        MealsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    public void mealsReCyclerListener(){
        listener=new mealsRecylclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent =new Intent(getApplicationContext(),MealShow.class);
                intent.putExtra("mealIndex",position);
                startActivity(intent);
            }
        };
    }
    public void macronutrientTVAndPBHandle(){
        day.calculateNutrition();
        remainPB.setProgress((int)(100-100*((float)(day.getRemainingCalories())/day.getUser().getCaloriesIntake())));
        if(day.getRemainingCalories()>=0){
            remainCalTV.setText(day.getRemainingCalories()+"\nremaining");
        }else{
            remainCalTV.setText(-1*day.getRemainingCalories()+"\nover");
        }
        carbsPB.setProgress((int) (((float)(day.getTakenCarbs())/day.getUser().getCarbsIntake())*100));
        carbsTV.setText(day.getTakenCarbs()+"\\"+day.getUser().getCarbsIntake());
        proteinPB.setProgress((int) (((float)(day.getTakenProtein())/day.getUser().getProteinIntake())*100));
        proteinTV.setText(day.getTakenProtein()+"\\"+day.getUser().getProteinIntake());
        fatPB.setProgress((int) (((float)(day.getTakenFat())/day.getUser().getFatIntake())*100));
        fatTV.setText(day.getTakenFat()+"\\"+day.getUser().getFatIntake());
    }
    public void attributeInitiate(){
        day=new Day(signUp.user);
        remainCalTV=findViewById(R.id.remainCalTV);
        carbsTV=findViewById(R.id.carbsTV);
        proteinTV=findViewById(R.id.proteinTV);
        fatTV=findViewById(R.id.fatTV);
        remainPB=findViewById(R.id.mealRemainPB);
        carbsPB=findViewById(R.id.carbsPB);
        proteinPB=findViewById(R.id.proteinPB);
        fatPB=findViewById(R.id.fatPB);
        MealsRecycler=findViewById(R.id.mealsRecycler);
        reCyclerMeals=new ArrayList<>();
        reCyclerMeals.add(day.getBreakfast());
        reCyclerMeals.add(day.getLaunch());
        reCyclerMeals.add(day.getDinner());
        reCyclerMeals.add(day.getSnack());
    }
}