package view;

import engine.Engine;
import engine.GAME_DISPLAY_STATE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;



/**
 * Created by Damien on 03/06/2017.
 */
public class Window extends JComponent implements KeyListener {

    int width,
        height;

    Engine engine;
    Frame frame;
    Game game;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;

        this.engine = new Engine(new Dimension(width, height));

        this.engine.loadSprites("Ressources/assets");

        this.game = new Game(this.engine);
        this.frame = null;

        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public void paint(Graphics graphics) {
        this.game.render(graphics);
    }

    public void launch() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.game.play();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.game.userPress(e);

        if (this.game.getState() == GAME_DISPLAY_STATE.DISPLAY_QUIT) {
            this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
