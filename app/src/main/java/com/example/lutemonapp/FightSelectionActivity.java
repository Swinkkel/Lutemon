package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class FightSelectionActivity extends AppCompatActivity {

    Context context;
    Button btnGoToArena;

    private int selection1 = -1;
    private int selection2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figth_selection);

        context = this;
        btnGoToArena = findViewById(R.id.btnGoToArena);
        btnGoToArena.setEnabled(false);

        makeSelectionLists();
    }

    private void makeSelectionLists() {
        RadioGroup rgSelection1 = findViewById(R.id.rgLutemonSelection1);
        rgSelection1.removeAllViews();
        rgSelection1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != selection2) {
                    selection1 = i;
                    if (selection2 != -1) {
                        // If we have selected both lutemons then activate go to arena button.
                        btnGoToArena.setEnabled(true);
                    }
                }
                else {
                    Toast.makeText(context, "Lutemon can't fight itself. Select another.", Toast.LENGTH_LONG).show();
                    radioGroup.clearCheck();
                }
            }
        });

        RadioGroup rgSelection2 = findViewById(R.id.rgLutemonSelection2);
        rgSelection2.removeAllViews();
        rgSelection2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != selection1) {
                    selection2 = i;
                    if (selection1 != -1) {
                        // If we have selected both lutemons then activate go to arena button.
                        btnGoToArena.setEnabled(true);
                    }
                }
                else {
                    Toast.makeText(context, "Lutemon can't fight itself. Select another.", Toast.LENGTH_LONG).show();
                    radioGroup.clearCheck();
                }
            }
        });

        ArrayList<Lutemon> lutemons = Storage.getInstance().getLutemons();

        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons) {
            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i);
            rgSelection1.addView(rb);

            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            rgSelection2.addView(rb);
        }
    }

    public void switchToArena(View view) {
        Intent intent = new Intent(this, FightingArenaActivity.class);
        intent.putExtra("Lutemon1", selection1);
        intent.putExtra("Lutemon2", selection2);
        startActivity(intent);
    }
}