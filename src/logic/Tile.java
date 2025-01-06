package src.logic;

import java.util.LinkedList;

// Object representing tile on board
public class Tile {

    private Tile next;

    public Tile getNextTile() {
        return next;
    }

    LinkedList<Player> players = new LinkedList<>();
}
