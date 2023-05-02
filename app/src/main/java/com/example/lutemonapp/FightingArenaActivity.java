package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FightingArenaActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;

    private Button exitArenaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_arena);

        Intent intent = getIntent();
        int lutemon1_ix = intent.getIntExtra("Lutemon1", -1);
        int lutemon2_ix = intent.getIntExtra("Lutemon2", -1);

        try {
            lutemon1 = Storage.getInstance().getLutemons().get(lutemon1_ix);
            lutemon2 = Storage.getInstance().getLutemons().get(lutemon2_ix);
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        TextView tvLutemon1 = findViewById(R.id.tvLutemon1);
        tvLutemon1.setText(lutemon1.getName());

        TextView tvLutemon2 = findViewById(R.id.tvLutemon2);
        tvLutemon2.setText(lutemon2.getName());

        // Enable scrollbar for text view
        TextView tvLog = findViewById(R.id.tvFightLog);
        tvLog.setMovementMethod(new ScrollingMovementMethod());

        exitArenaBtn = findViewById(R.id.btnExitArena);
        exitArenaBtn.setEnabled(false);
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void performFight(View view) {
        // Perform fight.
        int round = 0;

        // Print statistics to textview.
        TextView tvFightLog = findViewById(R.id.tvFightLog);

        while (true) {
            // At even rounds lutemon1 attakcs
            if (round % 2 == 0) {
                // Append lutemon stats to text view
                tvFightLog.append("1: " + lutemon1.stats() + "\n");
                tvFightLog.append("2: " + lutemon2.stats() + "\n");

                // Append information which lutemon attacks.
                tvFightLog.append(lutemon1.getName() + " attacks " +lutemon2.getName() + "\n");

                if (lutemon2.defense(lutemon1)) {
                    tvFightLog.append(lutemon2.getName() + " manages to escape death.\n");
                }
                else {
                    lutemon1.wins();
                    tvFightLog.append(lutemon2.getName() + " gets killed.\n");
                    break;
                }
            } else {
                // Append lutemon stats to text view
                tvFightLog.append("2: " + lutemon1.stats() + "\n");
                tvFightLog.append("1: " + lutemon2.stats() + "\n");

                // Append information which lutemon attacks.
                tvFightLog.append(lutemon1.getName() + " attacks " +lutemon2.getName() + "\n");

                if (lutemon1.defense(lutemon2)) {
                    tvFightLog.append(lutemon1.getName() + " manages to escape death.\n");
                }
                else {
                    lutemon2.wins();
                    tvFightLog.append(lutemon1.getName() + " gets killed.\n");
                    break;
                }
            }

            round++;
        }

        tvFightLog.append("The battle is over.\n");

        // Enable exit button after fight.
        exitArenaBtn.setEnabled(true);
    }
}