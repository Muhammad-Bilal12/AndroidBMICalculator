package com.devdroid.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt_weight, edt_HeightFt, edt_HeightInch;
        TextView resultTxt;
        Button btn_calculate;
        LinearLayout main_layout;

        edt_weight = findViewById(R.id.edt_weight);
        edt_HeightFt = findViewById(R.id.edt_HeightFT);
        edt_HeightInch = findViewById(R.id.edt_HeightInch);
        resultTxt = findViewById(R.id.result_txt);
        btn_calculate = findViewById(R.id.btn_calculate);
        main_layout = findViewById(R.id.main_layout);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt = Integer.parseInt(edt_weight.getText().toString());
                int heightFt = Integer.parseInt(edt_HeightFt.getText().toString());
                int heightInc = Integer.parseInt(edt_HeightInch.getText().toString());

                int totalInch = heightFt*12 + heightInc;
                double cm_height = totalInch*2.54;
                double m_height = cm_height/100;

                double bmi = wt/(m_height*m_height);

                if (bmi > 25){
                    main_layout.setBackgroundColor(getResources().getColor(R.color.colorOW));
                    resultTxt.setText("You Are Over Weight!");
                }else if (bmi >18.5 && bmi <24.9){
                    main_layout.setBackgroundColor(getResources().getColor(R.color.colorN));
                    resultTxt.setText("You are Normal!");
                }else{
                    main_layout.setBackgroundColor(getResources().getColor(R.color.colorUW));
                    resultTxt.setText("You are Under Weight!");
                }


            }
        });


    }
}