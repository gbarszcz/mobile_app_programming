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

    public void print(View v) {
        EditText name = findViewById(R.id.editTextName);
        EditText surname = findViewById(R.id.editTextSurname);
        EditText subject = findViewById(R.id.editTextSubject);
        EditText grade = findViewById(R.id.editTextAverageGrade);
        TextView result = findViewById(R.id.textViewNone);

        GradesHelper gradesHelper = new GradesHelper();
        boolean scholarship = gradesHelper.getScholarshipInfo(Double.parseDouble(grade.getText().toString()));

        result.setText(getString(R.string.scholarship,
                name.getText().toString(),
                surname.getText().toString(),
                subject.getText().toString(),
                scholarship ? "" : "nie "));
    }
}