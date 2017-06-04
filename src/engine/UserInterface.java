package engine;

import java.awt.*;

/**
 * Created by Damien on 04/06/2017.
 */
public class UserInterface {

    Engine engine;
    PlayerInfos infos;
    Dimension position;

    public UserInterface(Engine engine, PlayerInfos infos) {
        this.engine = engine;
        this.infos = infos;
        this.position = new Dimension(0, 430);
    }

    public void display(Graphics graphics, Renderer renderer) {
        for (int i=0; i<this.infos.getHealth(); i++) {
            graphics.drawImage(renderer.getSpriteImage("coeur2"), i*50, 430, null);
        }
    }
}
