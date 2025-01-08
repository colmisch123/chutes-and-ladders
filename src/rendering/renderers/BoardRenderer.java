package src.rendering.renderers;

import src.imp.Renderer;
import src.logic.Board;
import src.rendering.RenderEngine;


import java.awt.*;
import java.awt.geom.CubicCurve2D;

//Possible abstract to a RendererBase Class
public class BoardRenderer {
    private final RenderEngine engine;

    public BoardRenderer(RenderEngine engine) {
        this.engine = engine;
    }

    //TODO
    public void draw(Graphics2D g2, Board board) {
        board.forEach((tile) -> {
            g2.fillRect(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
        });
    }
}
