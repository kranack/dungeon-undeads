package engine;

import utils.Sprite;
import utils.SpriteObject;

import java.awt.*;

/**
 * Created by Damien on 05/06/2017.
 */
public class Player {

    Engine engine;

    Sprite sprite;
    SpriteObject spriteObject;

    public Player(Engine engine) {
        this.engine = engine;

        this.sprite = this.engine.getRenderer().getSprite("knight");
        this.spriteObject = new SpriteObject(this.sprite, 0, 200, this.engine.getRenderer().getLevel());
    }

    public SpriteObject getSpriteObject() { return this.spriteObject; }

    public void display(Graphics graphics, Renderer renderer) {
        if (renderer.getLevel() != null && renderer.getLevel() != this.spriteObject.getLevel()) {
            this.spriteObject = new SpriteObject(this.sprite, this.spriteObject.getX(), this.spriteObject.getY(), renderer.getLevel());
        }
        this.spriteObject.display(graphics, renderer);
    }
}
