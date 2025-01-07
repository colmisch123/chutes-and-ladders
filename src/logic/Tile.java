package src.logic;

import java.util.LinkedList;

// Object representing tile on board
public class Tile {

    private Tile next;
    private Tile previous;

    int length = 100;
    int height = 100;

    private Tile ladder;
    private Tile chute;

    //A linked list is used to keep track of players on each tile
    LinkedList<Player> players = new LinkedList<>();


    public boolean hasChuteOrLadder(){
        return !(ladder == null && chute == null);
    }

    public void setChute(Tile newChute){
        this.chute = newChute;
    }

    public void setLadder(Tile newLadder){
        this.ladder = newLadder;
    }

    public Tile getNextTile() {
        return next;
    }

    public Tile getPreviousTile() {
        return previous;
    }

    public void setPrevious(Tile newPrev){
        this.previous = newPrev;
    }

    public void setNext(Tile newNext){
        this.next = newNext;
    }

    public void removePlayerFromTile(Player player){
        players.remove(player);
    }

    public void addPlayerToTile(Player player){
        players.add(player);
    }

}
