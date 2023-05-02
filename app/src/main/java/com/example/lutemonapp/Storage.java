package com.example.lutemonapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

    private static Storage storage = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }

        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void saveToFile(Context context) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            writer.writeObject(lutemons);
            writer.close();
        } catch (IOException e) {
            System.out.println("Tallentaminen epäonnistui.");
        }
    }

    public void loadFromFile(Context context) {
        try {
            ObjectInputStream reader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) reader.readObject();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lukeminen epäonnistui.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lukeminen epäonnistui.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lukeminen epäonnistui.");
            e.printStackTrace();
        }
    }
}
