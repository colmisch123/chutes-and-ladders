package src.rendering.menu;

import src.rendering.RenderEngine;
import src.util.JBackgroundPanel;

import javax.swing.*;

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

        startPanel.add(start);

        return startPanel;
    }

    @Override
    public void onReset() {

    }
}
