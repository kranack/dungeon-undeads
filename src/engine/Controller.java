package engine;

import utils.SpriteObject;

import java.awt.event.KeyEvent;

/**
 * Created by Damien on 04/06/2017.
 */
public class Controller {

    SpriteObject spriteObject;

    public Controller(SpriteObject spriteObject) {
        this.spriteObject = spriteObject;
    }

    public void press(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32: // Space
            case 38: // Up arrow
            case 90: // Z
                this.spriteObject.move("up");
                break;
            case 37: // Left arrow
            case 81: // Q
                this.spriteObject.move("left");
                break;
            case 39: // Left arrow
            case 68: // Q
                this.spriteObject.move("right");
                break;
            default:
                break;
        }
    }

}
