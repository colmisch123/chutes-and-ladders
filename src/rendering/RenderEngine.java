package src.rendering;

import src.imp.Renderer;
import src.logic.Board;
import src.rendering.menu.GameBoardMenu;
import src.rendering.renderers.BoardRenderer;

import java.awt.*;
import java.util.ArrayList;

public class RenderEngine {
    private final Screen screen;
    private final ArrayList<Renderer> renderers = new ArrayList<>();
    private final BoardRenderer boardRenderer;

    //Used to test render engine
    private int x = 0;
    private int direction = 1;
    private int speed = 5;

    public RenderEngine(Screen screen) {
        this.screen = screen;
        boardRenderer = new BoardRenderer(this);
    }

    public void render(Graphics2D g2) {
        renderers.forEach(r -> r.render(g2));

        Board board = screen.getGameEngine().getBoard();
        boardRenderer.draw(g2, board);

        //This next code bit is purely for testing
        if(!(screen.getCurrentMenu() instanceof GameBoardMenu)) {
            return;
        }

        int boxSize = 100;

        for(int i = 0; i < 7; i++) {
            int y = (i * boxSize) + i;
            g2.setColor(new Color(255, 0, i * 25));
            g2.fillRect(x, y, boxSize, boxSize);
        }

        if (x + boxSize >= screen.getWidth()) {
            direction = -1;
        }

        if (x <= 0) {
            direction = 1;
        }

        x += (direction * speed);
    }

    public void addDrawable(Renderer renderer) {
        renderers.add(renderer);
    }

    public Screen getScreen() {
        return screen;
    }
}
