package com.example.pam_gr1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pam_gr1.Calculator;
import com.example.pam_gr1.R;

public class CalculatorActivity extends AppCompatActivity {
    EditText divisor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initButtons();
    }

    private void initButtons() {
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(addButtonOnClickListener);
        Button subtractButton = findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(subtractButtonOnClickListener);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(multiplyButtonOnClickListener);
        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setOnClickListener(divideButtonOnClickListener);
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(calculateButtonOnClickListener);
        divisor = findViewById(R.id.editTextScndNumber);
        divisor.setOnFocusChangeListener(divisorOnFocusChangeListener);
        Button showSubjectNameButton = findViewById(R.id.showSubjectNameButton);
        showSubjectNameButton.setOnLongClickListener(showSubjectNameButtonOnClickListener);
    }

    public void calculate(String operator) {
        EditText firstNumberInput = findViewById(R.id.editTextFrstNumber);
        EditText secondNumberInput = findViewById(R.id.editTextScndNumber);

        double firstNumber = Double.parseDouble(firstNumberInput.getText().toString());
        double secondNumber = Double.parseDouble(secondNumberInput.getText().toString());
        String result;
        switch (operator) {
            case "+":
                result = String.valueOf(Calculator.add(firstNumber, secondNumber));
                break;
            case "-":
                result = String.valueOf(Calculator.subtract(firstNumber, secondNumber));
                break;
            case "*":
                result = String.valueOf(Calculator.multiply(firstNumber, secondNumber));
                break;
            case "/":
                if (secondNumber == 0) {
                    result = getString(R.string.divisor_error);
                } else {
                    result = String.valueOf(Calculator.divide(firstNumber, secondNumber));
                }
                break;
            default:
                result = getString(R.string.invalid_operator, operator);
                Toast.makeText(CalculatorActivity.this, result, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, CalculatorResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    private View.OnClickListener addButtonOnClickListener = v -> calculate("+");

    private View.OnClickListener subtractButtonOnClickListener = v -> calculate("-");

    private View.OnClickListener multiplyButtonOnClickListener = v -> calculate("*");

    private View.OnClickListener divideButtonOnClickListener = v -> calculate("/");

    private View.OnClickListener calculateButtonOnClickListener = v -> {
        EditText editTextOperator = findViewById(R.id.editTextOperator);
        calculate(editTextOperator.getText().toString());
    };

    private View.OnLongClickListener showSubjectNameButtonOnClickListener = v -> {
        Toast.makeText(CalculatorActivity.this, getString(R.string.show_subject_name), Toast.LENGTH_SHORT).show();
        return true;
    };

    private View.OnFocusChangeListener divisorOnFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Editable divisorText = divisor.getText();
            if (divisorText != null && divisorText.toString().equals("0")) {
                Toast.makeText(CalculatorActivity.this, getString(R.string.divisor_error), Toast.LENGTH_SHORT).show();
            }
        }
    };
}
