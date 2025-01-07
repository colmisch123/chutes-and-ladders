package src.rendering.menu;

import src.rendering.RenderEngine;
import src.rendering.configure.ButtonConfigure;
import src.rendering.configure.LabelConfigure;
import src.util.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;

public class StartingMenu extends AbstractMenu {

    public StartingMenu(RenderEngine engine) {
        super(engine);
    }

    @Override
    public JPanel getBackground() {
        return new JBackgroundPanel("start.jpg");
    }

    @Override
    public JPanel getForeground() {
        JPanel startPanel = new JPanel();

        JLabel start = new JLabel();

        LabelConfigure.configure()
                .setText("Chutes")
                .setTextColor(new Color(100, 150, 0))
                .setSize(50)
                .confirm(start, startPanel, screen);

        JLabel and = new JLabel();

        LabelConfigure.configure()
                .setText("and")
                .setTextColor(new Color(100, 0, 100))
                .setSize(20)
                .setY(1)
                .confirm(and, startPanel, screen);

        JLabel ladders = new JLabel();

        LabelConfigure.configure()
                .setText("Ladders")
                .setTextColor(new Color(200, 150, 0))
                .setSize(50)
                .setY(2)
                .confirm(ladders, startPanel, screen);

        JButton startButton = new JButton();

        ButtonConfigure.configure()
                .setText("Start")
                .setHeight(50)
                .setWidth(100)
                .setY(3)
                .setNorth(100)
                .confirm(startButton, startPanel, screen);

        return startPanel;
    }

    @Override
    public void onReset() {

    }
}
