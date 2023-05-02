package com.example.lutemonapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonImage;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHealth, lutemonExperience;
    TextView lutemonNrTrainingDays, lutemonNrBattles, lutemonNrWins, lutemonNrLoses;

    LinearLayoutCompat rowItem;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        lutemonName = itemView.findViewById(R.id.tvLutemonName);
        lutemonAttack = itemView.findViewById(R.id.tvAttack);
        lutemonDefense = itemView.findViewById(R.id.tvDefense);
        lutemonHealth = itemView.findViewById(R.id.tvHealth);
        lutemonExperience = itemView.findViewById(R.id.tvExperience);

        lutemonNrTrainingDays = itemView.findViewById(R.id.tvTrainingDays);
        lutemonNrBattles = itemView.findViewById(R.id.tvNrBattles);
        lutemonNrWins = itemView.findViewById(R.id.tvNrWins);
        lutemonNrLoses = itemView.findViewById(R.id.tvNrLoses);

        rowItem = itemView.findViewById(R.id.rowitem);
    }
}
