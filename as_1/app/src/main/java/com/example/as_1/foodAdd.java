package com.example.as_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import entities.Day;
import entities.FoodSrc;
import entities.MealFood;

public class foodAdd extends AppCompatActivity {
    EditText foodNameEDT;
    EditText foodCompanyEDT;
    EditText foodCalEDT;
    EditText foodCarbsEDT;
    EditText foodProteinEDT;
    EditText foodFatEDT;
    EditText foodWeightEDT;
    Button foodAddBTN;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_add);
        attributeInitiate();
        addBtnOnClick();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void attributeInitiate(){
        foodNameEDT=findViewById(R.id.foodNameEDT);
        foodCompanyEDT=findViewById(R.id.foodCompanyEDT);
        foodCalEDT=findViewById(R.id.foodCalEDT);
        foodCarbsEDT=findViewById(R.id.foodCarbsEDT);
        foodProteinEDT=findViewById(R.id.foodProteinEDT);
        foodFatEDT=findViewById(R.id.foodFatEDT);
        foodWeightEDT=findViewById(R.id.foodWeightEDT);
        foodAddBTN=findViewById(R.id.foodAddBTN);
        extras=getIntent().getExtras();
    }
    public void addBtnOnClick(){
        foodAddBTN.setOnClickListener(e->{
            if(!String.valueOf(foodNameEDT.getText()).isEmpty()&&foodNameEDT.getText()!=null&&
                    !String.valueOf(foodCalEDT.getText()).isEmpty()&&foodCalEDT.getText()!=null&&
                    !String.valueOf(foodFatEDT.getText()).isEmpty()&&foodFatEDT.getText()!=null&&
                    !String.valueOf(foodWeightEDT.getText()).isEmpty()&&foodWeightEDT.getText()!=null) {
                String name=String.valueOf(foodNameEDT.getText());
                int calPer100=Integer.parseInt(String.valueOf(foodCalEDT.getText()));
                float carbsPer100=Float.parseFloat(String.valueOf(foodCarbsEDT.getText()));
                float proteinPer100=Float.parseFloat(String.valueOf(foodProteinEDT.getText()));
                float fatPer100=Float.parseFloat(String.valueOf(foodFatEDT.getText()));
                float weight=Float.parseFloat(String.valueOf(foodWeightEDT.getText()));
                float calculatedCalories=carbsPer100*4+proteinPer100*4+fatPer100*9;
                if(calPer100>calculatedCalories+50||calPer100<calculatedCalories-50){
                    Toast.makeText(getApplicationContext(), "macro nutrition doesn't add up", Toast.LENGTH_SHORT).show();
                }else{
                    FoodSrc type = new FoodSrc(name, calPer100, carbsPer100, proteinPer100, fatPer100);
                    MealFood food = new MealFood(type, weight);
                    MainScreen.reCyclerMeals.get(extras.getInt("index")).addFood(food);
                    finish();
                }

            }else{
                Toast.makeText(getApplicationContext(), "please enter all information", Toast.LENGTH_SHORT).show();
            }
        });
    }
}