package com.example.as_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import entities.User;

public class signUp extends AppCompatActivity {
    public static User user;
    Spinner activitySpinner;
    Spinner goalSpinner;
    Spinner nutritionSpinner;
    EditText nameEdt;
    EditText ageEdt;
    EditText lengthEdt;
    EditText weightEdt;
    CheckBox maleCheckBox;
    CheckBox femaleCheckBox;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        activitySpinner = findViewById(R.id.activitySpinner);
        goalSpinner = findViewById(R.id.goalSpinner);
        nutritionSpinner = findViewById(R.id.nutritionSpinner);
        nameEdt=findViewById(R.id.nameEdt);
        ageEdt=findViewById(R.id.ageEdt);
        lengthEdt=findViewById(R.id.lengthEdt);
        weightEdt=findViewById(R.id.weightEdt);
        maleCheckBox=findViewById(R.id.maleCheck);
        femaleCheckBox=findViewById(R.id.femaleCheck);
        submitBtn=findViewById(R.id.submitBtn);
        maleFemaleCheckBoxOnAction();
        submitOnAction();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void submitOnAction(){
        submitBtn.setOnClickListener(e->{
            String sex;
            if(maleCheckBox.isChecked()){
                sex="male";
            }else {
                sex="female";
            }
            if(nameEdt.getText().toString().equals("")||nameEdt.getText().toString().equals(null)||
                    ageEdt.getText().toString().equals("")||ageEdt.getText().toString().equals(null)||
                    lengthEdt.getText().toString().equals("")||lengthEdt.getText().toString().equals(null)||
                    weightEdt.getText().toString().equals("")||weightEdt.getText().toString().equals(null)){
                Toast.makeText(signUp.this, "Please enter all the info", Toast.LENGTH_LONG).show();
            } else {
                user = new User(nameEdt.getText().toString(), Float.parseFloat(weightEdt.getText().toString()),
                        Float.parseFloat(lengthEdt.getText().toString()), Integer.parseInt(ageEdt.getText().toString()),
                        goalSpinner.getSelectedItem().toString(), sex, nutritionSpinner.getSelectedItem().toString(),
                        activitySpinner.getSelectedItem().toString());
                Intent intent=new Intent(this, MainScreen.class);
                startActivity(intent);
            }
        });

    }
    public void maleFemaleCheckBoxOnAction(){
        maleCheckBox.setOnClickListener(e->{
            if(maleCheckBox.isChecked()){
                femaleCheckBox.setChecked(false);
            }
        });
        femaleCheckBox.setOnClickListener(e->{
            if(femaleCheckBox.isChecked()){
                maleCheckBox.setChecked(false);
            }
        });
    }

}