package com.example.pam_gr1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pam_gr1.R;

public class CreditsEditorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_editor);

        Button creditsButton = findViewById(R.id.saveCreditsButton);
        creditsButton.setOnClickListener(startCreditsActivity);
    }

    private View.OnClickListener startCreditsActivity = (View v) -> {
        EditText firstName = findViewById(R.id.editTextFirstName);
        EditText lastName = findViewById(R.id.editTextLastName);
        EditText subject = findViewById(R.id.editTextSubject);
        EditText classGroup = findViewById(R.id.editTextClassGroup);

        Intent intent = new Intent(this, CreditsActivity.class);
        intent.putExtra("firstName", firstName.getText().toString());
        intent.putExtra("lastName", lastName.getText().toString());
        intent.putExtra("subject", subject.getText().toString());
        intent.putExtra("classGroup", classGroup.getText().toString());
        startActivity(intent);
    };
}
