package com.example.pam_gr1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pam_gr1.R;

import java.util.Optional;

public class CreditsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        Button creditsButton = findViewById(R.id.editCreditsButton);
        creditsButton.setOnClickListener(startCreditsEditorActivity);

        initViewsFromExtras();
    }

    private void initViewsFromExtras() {
        Intent intent = getIntent();
        TextView firstName = findViewById(R.id.textViewFirstName);
        TextView lastName = findViewById(R.id.textViewLastName);
        TextView subject = findViewById(R.id.textViewSubject);
        TextView classGroup = findViewById(R.id.textViewClassGroup);
        firstName.setText(Optional.ofNullable(intent.getStringExtra("firstName")).orElse(""));
        lastName.setText(Optional.ofNullable(intent.getStringExtra("lastName")).orElse(""));
        subject.setText(Optional.ofNullable(intent.getStringExtra("subject")).orElse(""));
        classGroup.setText(Optional.ofNullable(intent.getStringExtra("classGroup")).orElse(""));
    }

    private View.OnClickListener startCreditsEditorActivity = (View v) -> {
        Intent intent = new Intent(this, CreditsEditorActivity.class);
        startActivity(intent);
    };

}
