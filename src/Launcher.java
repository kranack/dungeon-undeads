import view.*;
import view.Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Damien on 03/06/2017.
 */
public class Launcher {

    public static void main(String[] arg){
        JFrame frame = new JFrame("Dungeon Undeads v2");
        Window window = new Window(640, 480);

        window.setFrame(frame);

        frame.addKeyListener(window); //permet de prendre en compte les touches du clavier dans le jeu
        frame.setSize(640, 480);
        frame.add(window);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        window.launch();
    }
}
