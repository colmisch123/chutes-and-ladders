package src.logic;

import java.util.function.Consumer;

//Stores logic for the entire board
public class Board {
    //Starting Tile
    private Tile root;
    private final GameEngine engine;

    public Board(GameEngine engine) {
        this.engine = engine;
        this.root = new Tile();
        root.setPrevious(null);
    }

    public Tile getRoot() {
        return root;
    }

    //To iterate over each tile if needed
    public void forEach(Consumer<Tile> action) {
        forEachHelper(action, root);
    }

    private void forEachHelper(Consumer<Tile> action, Tile tile) {
        if(tile == null) {
            return;
        }
        action.accept(tile);
        forEachHelper(action, tile.getNextTile());
    }

    public void addTile(Tile newTile) {
        addTileHelper(root, newTile);
    }

    private void addTileHelper(Tile prev, Tile toAdd) {
        if(prev.getNextTile() == null) {
            prev.setNext(toAdd);
            return;
        }

        addTileHelper(prev.getNextTile(), toAdd);
    }

}
