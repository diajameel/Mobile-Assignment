package com.example.as_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MealShow extends AppCompatActivity {
    TextView mealCalTV;
    TextView mealCarbTV;
    TextView mealProteinTV;
    TextView mealFatTV;
    ImageView mealImage;
    ListView mealLV;
    Button mealAddBTN;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meal_show);
        attributeInitiate();
        viewsValueSet();
        addButtonListener();
        mealLVOnClick();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        attributeInitiate();
        viewsValueSet();
        addButtonListener();
        mealLVOnClick();
    }

    public void attributeInitiate(){
        extras=getIntent().getExtras();
        mealCalTV=findViewById(R.id.mealCalTV);
        mealCarbTV=findViewById(R.id.mealCarbTV);
        mealProteinTV=findViewById(R.id.mealProteinTV);
        mealFatTV=findViewById(R.id.mealFatTV);
        mealImage=findViewById(R.id.mealImage);
        mealLV=findViewById(R.id.mealLV);
        mealAddBTN=findViewById(R.id.mealAddBTN);
    }
    public void viewsValueSet(){
        if(extras!=null){
            int calories=MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getTakenCalories();
            float carbs=MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getTakenCarbs();
            float protein=MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getTakenProtein();
            float fat=MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getTakenfat();
            mealCalTV.setText(calories+"\nkcal");
            mealCarbTV.setText(Math.round(carbs*10.0)/10.0+"\ncarbs");
            mealProteinTV.setText(Math.round(protein*10.0)/10.0+"\nprotein");
            mealFatTV.setText(Math.round(fat*10.0)/10.0+"\nfat");
            mealImage.setImageResource(MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getIcon());
            ArrayAdapter arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).getEatenFood());
            mealLV.setAdapter(arrayAdapter);
        }
    }
    public void addButtonListener(){
        mealAddBTN.setOnClickListener(e->{
            Intent intent =new Intent(getApplicationContext(),foodAdd.class);
            intent.putExtra("index",extras.getInt("mealIndex"));
            startActivity(intent);
        });
    }
    public void mealLVOnClick(){
        mealLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MainScreen.reCyclerMeals.get(extras.getInt("mealIndex")).removeFood(position);
                viewsValueSet();
                return false;
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
//        Intent intent=new Intent(this,MainScreen.class);
//        startActivity(intent);
    }
}