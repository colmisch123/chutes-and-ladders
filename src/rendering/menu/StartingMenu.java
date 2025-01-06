package src.rendering.menu;

import src.rendering.RenderEngine;
import src.util.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;

public class StartingMenu extends AbstractMenu {

    public StartingMenu(RenderEngine engine) {
        super(engine);
    }

    @Override
    public JPanel getBackground() {
        return new JBackgroundPanel("silly_cat.jpg");
    }

    @Override
    public JPanel getForeground() {
        JPanel startPanel = new JPanel();

        JLabel start = new JLabel("Hello World");

        start.setForeground(new Color(150, 150, 0));
        start.setFont(new Font("Dialog", Font.PLAIN, 25));

        startPanel.add(start);

        return startPanel;
    }

    @Override
    public void onReset() {

    }
}
