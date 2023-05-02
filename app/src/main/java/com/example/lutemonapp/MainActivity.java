package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
    }

    /* Called when Add button pressed in main activity UI. */
    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    /* Called when List button pressed in main activity UI. */
    public void switchToListLutemons(View view) {
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToTrainLutemons(View view) {
        Intent intent = new Intent(this, TrainLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToFightSelection(View view) {
        Intent intent = new Intent(this, FightSelectionActivity.class);
        startActivity(intent);
    }

    public void saveLutemons(View view) {
        Storage.getInstance().saveToFile(view.getContext());
    }

    public void loadLutemons(View view) {
        Storage.getInstance().loadFromFile(view.getContext());
    }
}