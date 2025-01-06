package src.logic;

import src.imp.Tickable;

import java.util.ArrayList;

public class GameEngine {
    private final ArrayList<Tickable> tickables = new ArrayList<>();
    private final Board board;

    public GameEngine() {
        this.board = new Board(this);
    }

    public void tick() {
        tickables.forEach(Tickable::tick);
    }

    public void addTickable(Tickable ticker) {
        tickables.add(ticker);
    }

    public Board getBoard() {
        return this.board;
    }

    public int diceRoll(){
        return (int)(Math.random() * 6) + 1;
    }

    //Need a function to move player
}
