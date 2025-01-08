package src.rendering.menu;

import src.imp.Renderer;
import src.rendering.RenderEngine;
import src.util.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoardMenu extends AbstractMenu implements Renderer {

    public GameBoardMenu(RenderEngine engine) {
        super(engine);
    }

    @Override
    public JPanel getBackground() {
        return new JBackgroundPanel("silly_cat.jpg");
    }

    @Override
    public JPanel getForeground() {
        JPanel start = new JPanel();

        return start;
    }

    @Override
    public void onReset() {

    }

    @Override
    public void render(Graphics2D g2) {

    }
}
