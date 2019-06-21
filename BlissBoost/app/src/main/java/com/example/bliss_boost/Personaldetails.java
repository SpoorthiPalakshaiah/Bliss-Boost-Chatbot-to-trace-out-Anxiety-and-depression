package com.example.bliss_boost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Personaldetails extends AppCompatActivity {

    EditText age,height,weight;
    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4;
    RadioButton radioButton;
    double mt=0.305;
    double body_mass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetails);
        age=(EditText) findViewById(R.id.agetext);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);

        radioGroup1 =(RadioGroup) findViewById(R.id.rg1);
        radioGroup2 =(RadioGroup) findViewById(R.id.rg2);
        radioGroup3 =(RadioGroup) findViewById(R.id.rg3);
        radioGroup4 =(RadioGroup) findViewById(R.id.rg4);
    }

    public void submitForm(View view) {
        int a= Integer.parseInt(age.getText().toString());
        double hgt=Double.parseDouble(height.getText().toString());
        double wgt=Double.parseDouble(weight.getText().toString());

        if(age.equals("")||height.equals("")||weight.equals("")){
            Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
        }
        else {
            //Toast.makeText(getApplicationContext(), "Details Uploaded", Toast.LENGTH_SHORT).show();

            double m2 = (hgt * mt) * (hgt * mt);
            body_mass = wgt / m2;
            //Toast.makeText(getApplicationContext(), " BMI " + body_mass, Toast.LENGTH_SHORT).show();
        }

        if (body_mass < 18.5) {
            Toast.makeText(getApplicationContext(), "According to your body mass index," + body_mass + " you are considered to be UNDERWEIGHT", Toast.LENGTH_SHORT).show();

        }
        if (body_mass >= 18.5 && body_mass <= 24.9) {
            Toast.makeText(getApplicationContext(), "According to your body mass index," + body_mass + " you are considered to be within a healthy weight range", Toast.LENGTH_SHORT).show();

        }
        if (body_mass >= 25.0 && body_mass <= 29.90) {
            Toast.makeText(getApplicationContext(), "According to your body mass index," + body_mass + " you are considered to be OVERWEIGHT", Toast.LENGTH_SHORT).show();

        }
        if (body_mass >= 30) {
            Toast.makeText(getApplicationContext(), "According to your body mass index," + body_mass + " you are considered to be OBESE", Toast.LENGTH_SHORT).show();

        }


    }

}

