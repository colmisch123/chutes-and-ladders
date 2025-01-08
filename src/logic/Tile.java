package src.logic;

import java.util.LinkedList;

// Object representing tile on board
public class Tile {

    // Used for default values, to ensure no magic numbers
    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 100;

    private Tile next;
    private Tile previous;

    private int width;
    private int height;

    private int x;
    private int y;

    private Tile ladder;
    private Tile chute;

    // A linked list is used to keep track of players on each tile
    LinkedList<Player> players = new LinkedList<>();

    public Tile(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Tile() {
        this(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public boolean hasChuteOrLadder() {
        return !(ladder == null && chute == null);
    }

    public void setChute(Tile newChute) {
        this.chute = newChute;
    }

    public void setLadder(Tile newLadder) {
        this.ladder = newLadder;
    }

    public Tile getNextTile() {
        return next;
    }

    public Tile getPreviousTile() {
        return previous;
    }

    public void setPrevious(Tile newPrev) {
        this.previous = newPrev;
    }

    public void setNext(Tile newNext) {
        this.next = newNext;
    }

    public void removePlayerFromTile(Player player) {
        players.remove(player);
    }

    public void addPlayerToTile(Player player) {
        players.add(player);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
