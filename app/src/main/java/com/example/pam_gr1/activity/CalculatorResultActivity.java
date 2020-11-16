package com.example.pam_gr1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pam_gr1.R;

public class CalculatorResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);

        TextView resultTextView = findViewById(R.id.textViewResult);
        Intent intent = getIntent();
        resultTextView.setText(intent.getStringExtra("result"));
    }
}
