package src.rendering.menu;

import src.imp.Drawable;
import src.rendering.RenderEngine;
import src.rendering.Screen;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractMenu implements Drawable {
    protected final RenderEngine engine;
    protected final Screen screen;
    protected JLayeredPane pane;
    protected JPanel background;
    protected JPanel foreground;

    protected int width = 0;
    protected int height = 0;

    public AbstractMenu(RenderEngine engine) {
        this.engine = engine;
        this.screen = engine.getScreen();

        priorityInit();

        this.pane = new JLayeredPane();
        this.width = engine.getScreen().getWidth();
        this.height = engine.getScreen().getHeight();
        this.background = getBackground();
        this.foreground = getForeground();

        foreground.setLayout(engine.getScreen().getLayout());

        pane.setBounds(0, 0, width, height);
        background.setBounds(0, 0, width, height);
        foreground.setBounds(0, 0, width, height);

        foreground.setOpaque(false);

        this.pane.add(background, JLayeredPane.DEFAULT_LAYER);
        this.pane.add(foreground, JLayeredPane.PALETTE_LAYER);

        engine.addDrawable(this);
    }

    public JLayeredPane getPane() {
        return this.pane;
    }

    public void draw(Graphics2D g2) {
        if(engine.getScreen().hasScreenBeenResized()) {
            resize();
        }
    }

    private void resize() {
        this.width = engine.getScreen().getWidth();
        this.height = engine.getScreen().getHeight();

        this.foreground.setBounds(0, 0, width, height);
        this.background.setBounds(0, 0, width, height);
        this.pane.setBounds(0, 0, width, height);

        this.pane.revalidate();
    }

    public abstract JPanel getBackground();
    public abstract JPanel getForeground();

    //These methods are useful because they get called in very specific locations.
    //Meant to be "@Override"-ed
    public void onSetActive() {}
    public void onRemove() {}
    protected void priorityInit() {}

    //Called when everything should be reset to init state
    public abstract void onReset();
}
