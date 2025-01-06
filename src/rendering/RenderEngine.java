package src.rendering;

import src.imp.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class RenderEngine implements Drawable {
    private Screen screen;
    private ArrayList<Drawable> drawables = new ArrayList<>();

    public RenderEngine(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void draw(Graphics2D g) {
        drawables.forEach((d) -> {
            d.draw(g);
        });
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    public Screen getScreen() {
        return screen;
    }
}
