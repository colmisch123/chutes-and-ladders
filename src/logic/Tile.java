package src.logic;

import java.util.LinkedList;

// Object representing tile on board
public class Tile {

    private Tile next;

    public Tile getNextTile() {
        return next;
    }

    public void removePlayerFromTile(Player player){
        players.remove(player);
    }

    public void addPlayerToTile(Player player){
        players.add(player);
    }

    LinkedList<Player> players = new LinkedList<>();


}
