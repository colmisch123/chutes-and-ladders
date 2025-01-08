package src.util;

import src.rendering.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

//Used to be a top layer renderer on a JFrame
public class RenderPanel extends JPanel {
    private Consumer<Graphics2D> toRender;

    //This code was in the Screen constructor, made it too bloated though. Code is now here for ease of readability.
    public RenderPanel(Screen screen) {
        super();
        setOpaque(false);
        setToRender(screen::render);
        setBounds(0, 0, screen.getWidth(), screen.getHeight());
        screen.getContentPane().add(this, JLayeredPane.POPUP_LAYER);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(toRender != null) {
            Graphics2D g2 = (Graphics2D) g;
            toRender.accept(g2);
        }

        g.dispose();
    }

    public void setToRender(Consumer<Graphics2D> toRender) {
        this.toRender = toRender;
    }
}
