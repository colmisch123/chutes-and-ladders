package src.rendering;

import src.imp.Renderer;
import src.logic.Board;
import src.rendering.renderers.BoardRenderer;

import java.awt.*;
import java.util.ArrayList;

public class RenderEngine {
    private final Screen screen;
    private final ArrayList<Renderer> renderers = new ArrayList<>();
    private final BoardRenderer boardRenderer;

    public RenderEngine(Screen screen) {
        this.screen = screen;
        boardRenderer = new BoardRenderer(this);
    }

    public void render(Graphics2D g2) {
        renderers.forEach(r -> r.render(g2));

        Board board = screen.getGameEngine().getBoard();
        boardRenderer.draw(g2, board);
    }

    public void addDrawable(Renderer renderer) {
        renderers.add(renderer);
    }

    public Screen getScreen() {
        return screen;
    }
}
