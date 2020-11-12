package com.example.pam_gr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v) {
        EditText firstNumberInput = findViewById(R.id.editTextFirstNumber);
        EditText secondNumberInput = findViewById(R.id.editTextSecondNumber);

        double firstNumber = Double.parseDouble(firstNumberInput.getText().toString());
        double secondNumber = Double.parseDouble(secondNumberInput.getText().toString());
        String result;
        switch (v.getId()) {
            case R.id.add:
                result = String.valueOf(Calculator.add(firstNumber, secondNumber));
                break;
            case R.id.subtract:
                result = String.valueOf(Calculator.subtract(firstNumber, secondNumber));
                break;
            case R.id.multiply:
                result = String.valueOf(Calculator.multiply(firstNumber, secondNumber));
                break;
            case R.id.divide:
                if (secondNumber == 0) {
                    result = "Cannot divide by 0!";
                } else {
                    result = String.valueOf(Calculator.divide(firstNumber, secondNumber));
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(result);
    }

    public void charCounter(View v) {
        StringHelper stringHelper = new StringHelper();
        EditText string = findViewById(R.id.editTextInputText);
        EditText character = findViewById(R.id.editTextOneChar);
        long count = stringHelper.countChar(string.getText().toString(), character.getText().toString().charAt(0));

        TextView result = findViewById(R.id.textViewCharCounter);
        result.setText(String.valueOf(count));
    }
}