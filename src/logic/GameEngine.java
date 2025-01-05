package src.logic;

import src.imp.Tickable;

import java.util.ArrayList;

public class GameEngine {
    private final ArrayList<Tickable> tickables = new ArrayList<>();

    public GameEngine() {

    }

    public void tick() {
        tickables.forEach(Tickable::tick);
    }

    public void addTickable(Tickable ticker) {
        tickables.add(ticker);
    }
}
