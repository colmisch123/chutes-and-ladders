package src.rendering.menu;

import src.imp.Renderer;
import src.rendering.RenderEngine;
import src.util.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoardMenu extends AbstractMenu implements Renderer {
    private int x = 0;
    private int direction = 1;
    private int speed = 5;
    private boolean hasHitEdge = false;

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
        if(screen.getCurrentMenu() != this) {
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
}
