package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonTrainListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

    public LutemonTrainListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());

        holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.lutemonAttack.setText("Attack: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefense.setText("Defense: " + String.valueOf(lutemons.get(position).getDefense()));
        holder.lutemonHealth.setText("Health: " + String.valueOf(lutemons.get(position).getHealth()) + "/" + String.valueOf(lutemons.get(position).getMaxHealth()));
        holder.lutemonExperience.setText("Experience: " + String.valueOf(lutemons.get(position).getExperience()));

        holder.lutemonNrTrainingDays.setText("Training days: " + String.valueOf(lutemons.get(position).getNrTrainingDays()));
        holder.lutemonNrBattles.setText("Number of battles: " + String.valueOf(lutemons.get(position).getNrBattles()));
        holder.lutemonNrWins.setText("Number of wins: " + String.valueOf(lutemons.get(position).getNrWins()));
        holder.lutemonNrLoses.setText("Number of loses: " + String.valueOf(lutemons.get(position).getNrLoses()));

        holder.rowItem.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().lutemons.get(pos).train();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
