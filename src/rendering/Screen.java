package src.rendering;

import src.logic.GameEngine;
import src.rendering.menu.AbstractMenu;
import src.rendering.menu.GameBoardMenu;
import src.rendering.menu.StartingMenu;
import src.util.RenderPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Screen extends JFrame implements Runnable {
    private final static int FPS = 60;

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    public int screenWidth = screenSize.width;
    public int screenHeight = screenSize.height;

    private final GameEngine gameEngine;
    private final RenderEngine renderEngine;

    //When the screen is resized, every runnable action in this list gets activated.
    private final LinkedList<Runnable> onResizeEvent = new LinkedList<>();

    private AbstractMenu currentMenu;
    private final AbstractMenu startingMenu;
    private final GameBoardMenu gameBoardMenu;

    //Used for detecting when the screen size changes.
    private Dimension sizeCache;

    private final GridBagLayout layout = new GridBagLayout();

    //Panels have double buffers, not JFrames, this layer is always placed on the highest level.
    private final RenderPanel renderPanel;

    public Screen() {
        setTitle("Chutes and Ladders");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((int) screenWidth / 4, (int) screenHeight / 10, 960, 720);
        setLayout(null);
        setContentPane(new JLayeredPane());

        sizeCache = getSize();

        gameEngine = new GameEngine();
        renderEngine = new RenderEngine(this);

        startingMenu = new StartingMenu(renderEngine);
        gameBoardMenu = new GameBoardMenu(renderEngine);

        renderPanel = new RenderPanel(this);
        addResizeEvent(() -> renderPanel.setBounds(0, 0, getWidth(), getHeight()));

        setMenu(startingMenu);
    }

    //For Menu objects only. Will remove the old pane from Container. DOES NOT REPLACE THE CONTENT PANE.
    public void setMenu(AbstractMenu menu) {
        if(currentMenu != null) {
            currentMenu.onRemove();
            getContentPane().remove(currentMenu.getPane());
        }

        getContentPane().add(menu.getPane(), JLayeredPane.DEFAULT_LAYER);

        menu.onSetActive();
        currentMenu = menu;
    }

    public void addResizeEvent(Runnable event) {
        onResizeEvent.add(event);
    }

    //This code is run every second. This code is for logic purposes only.
    private void tick() {
        if(hasScreenBeenResized()) {
            onResizeEvent.forEach(Runnable::run);
        }

        gameEngine.tick();
    }

    //This code gets run in the render layer.
    public void render(Graphics2D g2) {
        renderEngine.render(g2);

        g2.dispose();
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

    private boolean hasScreenBeenResized() {
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

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public AbstractMenu getGameBoardMenu() {
        return gameBoardMenu;
    }
}
