package src.rendering;

import src.logic.GameEngine;
import src.rendering.menu.AbstractMenu;
import src.rendering.menu.GameBoardMenu;
import src.rendering.menu.StartingMenu;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame implements Runnable {
    private final static int FPS = 60;

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    public int screenWidth = screenSize.width;
    public int screenHeight = screenSize.height;

    private final GameEngine gameEngine;
    private final RenderEngine renderEngine;

    private AbstractMenu currentMenu;
    private final AbstractMenu startingMenu;
    private final GameBoardMenu gameBoardMenu;

    private Dimension sizeCache;

    private final GridBagLayout layout = new GridBagLayout();

    public Screen() {
        setTitle("Chutes and Ladders");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((int) screenWidth / 4, (int) screenHeight / 10, 960, 720);
        setLayout(null);

        sizeCache = getSize();

        gameEngine = new GameEngine();
        renderEngine = new RenderEngine(this);

        startingMenu = new StartingMenu(renderEngine);
        gameBoardMenu = new GameBoardMenu(renderEngine);

        setMenu(startingMenu);
    }

    public void setMenu(AbstractMenu menu) {
        if(currentMenu != null) {
            currentMenu.onRemove();
        }
        menu.onSetActive();
        currentMenu = menu;
        setContentPane(menu.getPane());
    }

    public boolean hasScreenBeenResized() {
        Dimension currentSize = getSize();

        if(sizeCache.equals(currentSize)) {
            return false;
        }

        this.sizeCache = currentSize;
        return true;
    }

    public GridBagLayout getLayout() {
        return layout;
    }

    public AbstractMenu getCurrentMenu() {
        return currentMenu;
    }

    public AbstractMenu getGameBoardMenu() {
        return gameBoardMenu;
    }

    @Override
    public void run() {
        long drawInterval = 1000000000/FPS;
        long nextDrawTime = System.nanoTime() + drawInterval; //Calculates the allowed amount of time the thread has until it runs again

        while(isVisible()) {
            long currentTime = System.nanoTime();
            if (System.nanoTime() - currentTime < FPS ) {
                tick();
                repaint();

                try {
                    long remaningTime = nextDrawTime - System.nanoTime();
                    remaningTime = remaningTime/1000000; //convert to miliseconds

                    if (remaningTime < 0) {
                        remaningTime = 0;
                    }

                    Thread.sleep(remaningTime);

                    nextDrawTime += drawInterval;
                } catch (InterruptedException ignored) {
                    System.out.println("Thread skipped");
                }
            }
        }
    }

    private void tick() {
        gameEngine.tick();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        renderEngine.draw(g2);

        g2.dispose();
    }
}
