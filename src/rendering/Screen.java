package src.rendering;

import src.logic.GameEngine;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame implements Runnable {
    private final static int FPS = 60;
    private final static int WIDTH = 400;

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    public int screenWidth = screenSize.width;
    public int screenHeight = screenSize.height;

    private final GameEngine gameEngine;

    public Screen() {
        setTitle("Chutes and Ladders");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((int) screenWidth / 4, (int) screenHeight / 10, 960, 720);
        setLayout(null);

        gameEngine = new GameEngine();
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
}
