package src.rendering.menu;

import src.rendering.RenderEngine;
import src.util.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;

public class GameBoardMenu extends AbstractMenu {
    private int x = 0;

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
    public void draw(Graphics2D g2) {
        super.draw(g2);

        background.setBackground(Color.WHITE);

        if(screen.getCurrentMenu() == this) {
            g2.setColor(new Color(255, 0, 0));
            g2.fillRect(x, 100, 100, 100);
            x++;
        }
    }
}
