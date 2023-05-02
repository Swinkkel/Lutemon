package com.example.lutemonapp;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private String name;
    private String color;
    private int attack;
    private int defense;
    private int experience = 0;
    private int health;
    private int maxHealth;

    protected int image;

    // Battle related statistics.
    private int nrWins = 0;

    private int nrLoses = 0;

    // Training related statistics;
    private int nrTrainingDays;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getNrBattles() {
        return nrWins + nrLoses;
    }

    public int getNrWins() {
        return nrWins;
    }

    public int getNrLoses() {
        return nrLoses;
    }

    public int getNrTrainingDays() {
        return nrTrainingDays;
    }

    public int getImage() {
        return image;
    }

    public void train() {
        experience += 1;
        nrTrainingDays += 1;
    }

    // Returns Lutemons attack power.
    public int attack() {
        // Add some randomness to attack.
        int min_attack = attack/2;
        int max_attack = attack + attack/2;
        return min_attack + (int)(Math.random() * ((max_attack - min_attack) + 1)) + experience;
    }

    /*
    *   @return true if lutemon managed to defend the attack
    *   @return false if lutemon failed to defend attack and dies.
    */
    public boolean defense(Lutemon lutemon) {
        health -= lutemon.attack() - defense;
        if (health <= 0) {
            // When lutemon dies it loses all experience gained.
            loses();
            return false;
        }

        return true;
    }

    // Called when lutemon loses a battle. Reset experience,
    // set health back to maximum and increase number of lost battles.
    private void loses() {
        health = maxHealth;
        experience = 0;
        nrLoses += 1;
    }

    // Called when lutemon wins a battle. Gains one experience point and win.
    public void wins() {
        nrWins += 1;
        experience += 1;
    }

    public String stats() {
        return name + "("+color+") att: " +String.valueOf(attack)+ " def: "+String.valueOf(defense)+ " exp: "+String.valueOf(experience)+" health: "+String.valueOf(health) + "/" + String.valueOf(maxHealth);
    }
}
