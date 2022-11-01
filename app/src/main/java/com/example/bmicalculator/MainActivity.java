package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edWeg,edHei;
        TextView txtRes,txtInter;
        Button btnRes,btnReset;

        edWeg=(EditText) findViewById(R.id.edWeg);
        edHei=(EditText) findViewById(R.id.edHei);

        txtRes=(TextView) findViewById(R.id.txtRes);
        txtInter=(TextView) findViewById(R.id.txtInter);

        btnRes=(Button) findViewById(R.id.btnRes);
        btnReset=(Button) findViewById(R.id.btnReset);

        btnRes.setOnClickListener(v -> {
            String strweg = edWeg.getText().toString();
            String strhei = edHei.getText().toString();

            if (strweg.equals("")){
                edWeg.setError("Please Enter Your Weight");
                edWeg.requestFocus();
                return;
            }

            if (strhei.equals("")) {
                edHei.setError("Please Enter Your Height");
                edHei.requestFocus();
                return;
            }
            float weight = Float.parseFloat(strweg);
            float height= Float.parseFloat(strhei)/100;

            float bmiVlaue = BMICalculate(weight,height);

            txtInter.setText(interpreteBMI(bmiVlaue));
            txtRes.setText("BMI= "+bmiVlaue);

        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");

            }
        });
    }
    public float BMICalculate (float weight, float height) {
        return weight / (height * height);
    }
    public String interpreteBMI (float bmivalue) {
        if (bmivalue <18.5) {
            return "Servely Underweight";
        }
        else if (bmivalue <25.0){
            return "Normal";
        }
        else if (bmivalue <30) {
            return "Pre-Obesity";
        }
        else if (bmivalue < 35) {
            return "Obesity class 1";
        }
        else if (bmivalue <40) {
            return "Obesity class 2";
        }
        else if (bmivalue < 50) {
            return "Obesity class 3";
        }
        else
            return "Obese";
    }
}