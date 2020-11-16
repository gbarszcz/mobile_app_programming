package com.example.pam_gr1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pam_gr1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button creditsButton = findViewById(R.id.creditsButton);
        creditsButton.setOnClickListener(startCreditsActivity);
        Button calculatorButton = findViewById(R.id.calculatorButton);
        calculatorButton.setOnClickListener(startCalculatorActivity);
    }

    private View.OnClickListener startCreditsActivity = (View v) -> {
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    };

    private View.OnClickListener startCalculatorActivity = (View v) -> {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    };

}