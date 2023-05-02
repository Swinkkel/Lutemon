package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addNewLutemon(View view) {

        EditText etLutemonName = findViewById(R.id.editTextLutemonName);
        String lutemonName = etLutemonName.getText().toString();
        if (lutemonName.isEmpty()) {
            // User didn't give name
            Toast.makeText(view.getContext(), "Lutemon must have name", Toast.LENGTH_LONG).show();
            return;
        }

        RadioGroup rgLutemonType = findViewById(R.id.rgLutemonType);
        switch (rgLutemonType.getCheckedRadioButtonId()) {
            case R.id.rbWhiteLutemon:
                Storage.getInstance().addLutemon(new White(lutemonName));
                break;
            case R.id.rbGreenLutemon:
                Storage.getInstance().addLutemon(new Green(lutemonName));
                break;
            case R.id.rbOrangeLutemon:
                Storage.getInstance().addLutemon(new Orange(lutemonName));
                break;
            case R.id.rbPinkLutemon:
                Storage.getInstance().addLutemon(new Pink(lutemonName));
                break;
            case R.id.rbBlackLutemon:
                Storage.getInstance().addLutemon(new Black(lutemonName));
                break;
        }

        // Clear name to indicate that Lutemon was added.
        etLutemonName.getText().clear();
    }
}