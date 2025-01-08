package src;

import src.logic.Board;
import src.logic.Tile;
import src.rendering.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);

        Thread thread = new Thread(screen);
        thread.start();

        //DUMMY BOARD
        createDummyBoard(screen.getGameEngine().getBoard());
    }

    //Creates dummy board
    private static void createDummyBoard(Board board) {
        int max = 25;

        for(int y = 0; y < max; y++) {
            for(int x = 0; x < max; x++) {
                board.addTile(new Tile(x, y, Tile.DEFAULT_WIDTH, Tile.DEFAULT_HEIGHT));
            }
        }
    }
}
