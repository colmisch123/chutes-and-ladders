package src.rendering.configure;

import src.rendering.Screen;

import javax.swing.*;
import java.awt.*;

public class LabelConfigure {
    //Location
    private int x = 0;
    private int y = 0;

    //Width and height of gridbox
    private int width = 0;
    private int height = 0;

    //Spacing
    private int north = 0;
    private int west = 0;
    private int south = 0;
    private int east = 0;

    //Text on label
    private String text = "";

    //Color of text
    private Color textColor = new Color(255, 255, 255);

    //Font
    private String font = "Dialog";

    //Style - EX Bold
    private int style = Font.PLAIN;

    //Size of text
    private int size = 1;

    private boolean visible = true;

    //Color of Button
    private Color backgroundColor;

    public LabelConfigure setX(int x) {
        this.x = x;
        return this;
    }

    public LabelConfigure setY(int y) {
        this.y = y;
        return this;
    }

    public LabelConfigure setWidth(int width) {
        this.width = width;
        return this;
    }

    public LabelConfigure setHeight(int height) {
        this.height = height;
        return this;
    }

    public LabelConfigure setNorth(int north) {
        this.north = north;
        return this;
    }

    public LabelConfigure setWest(int west) {
        this.west = west;
        return this;
    }

    public LabelConfigure setSouth(int south) {
        this.south = south;
        return this;
    }

    public LabelConfigure setEast(int east) {
        this.east = east;
        return this;
    }

    public LabelConfigure setText(String text) {
        this.text = text;
        return this;
    }

    public LabelConfigure setTextColor(Color color) {
        this.textColor = color;
        return this;
    }

    public LabelConfigure setTextColor(int red, int green, int blue) {
        int r = Math.min(255, Math.max(0, red));
        int g = Math.min(255, Math.max(0, green));
        int b = Math.min(255, Math.max(0, blue));
        this.textColor = new Color(r, g, b);
        return this;
    }

    public LabelConfigure setFont(String font) {
        this.font = font;
        return this;
    }

    public LabelConfigure setStyle(int style) {
        this.style = style;
        return this;
    }

    public LabelConfigure setSize(int size) {
        this.size = size;
        return this;
    }

    public LabelConfigure setInvisible() {
        this.visible = false;
        return this;
    }

    public LabelConfigure setBackgroundColor(int red, int green, int blue) {
        int r = Math.min(255, Math.max(0, red));
        int g = Math.min(255, Math.max(0, green));
        int b = Math.min(255, Math.max(0, blue));

        this.backgroundColor = new Color(r, g, b);

        return this;
    }

    public LabelConfigure setBackgroundColor(Color color) {
        this.backgroundColor = color;
        return this;
    }

    public void confirm(JLabel label, JPanel panel, Screen screen) {
        confirm(label, panel, GridBagConstraints.CENTER, screen);
    }

    public void confirm(JLabel label, JPanel panel, int layout, Screen screen) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;

        gbc.ipadx = width;
        gbc.ipady = height;

        gbc.insets = new Insets(north, west, south, east);

        gbc.anchor = layout;

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setText(text);
        label.setForeground(textColor);
        label.setFont(new Font(font, style, size));
        screen.getLayout().setConstraints(label, gbc);
        panel.add(label);
        label.setVisible(visible);

        if(backgroundColor != null) {
            label.setOpaque(true);
            label.setBackground(backgroundColor);
        }
    }

    public static LabelConfigure configure() {
        return new LabelConfigure();
    }
}
