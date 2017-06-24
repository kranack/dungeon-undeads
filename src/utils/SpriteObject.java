package utils;

import engine.Level;
import engine.Renderer;

import java.awt.*;

/**
 * Created by Damien on 04/06/2017.
 */
public class SpriteObject {

    static int SPRITE_SPEED         = 5;
    static int SPRITE_BOUND         = 4;
    static int SPRITE_BOX_HEIGHT    = 50;
    static int SPRITE_BOX_WIDTH     = 50;

    static int SPRITE_BOUNDS_HEIGHT = 89;
    static int SPRITE_BOUNDS_WIDTH  = 49;

    private Sprite sprite;
    private Level level;

    private int x, y;
    private int vx, vy;

    public SpriteObject(Sprite sprite, int x, int y, Level level) {
        this.sprite = sprite;
        this.level = level;

        this.x = x;
        this.y = y;
        this.vx = this.vy = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Level getLevel() {
        return this.level;
    }

    Rectangle getBounds() {
        return new Rectangle(this.x, this.y, SPRITE_BOUNDS_WIDTH, SPRITE_BOUNDS_HEIGHT);
    }

    boolean intersects(Rectangle n){
        return (this.x == n.x);
    }

    public void interact() {
        if (level.isValid(this.x, this.y+SPRITE_BOUND, SPRITE_BOX_WIDTH, SPRITE_BOX_HEIGHT)){
            this.y = this.y + SPRITE_BOUND;
        }
    }

    public void interact(int x, int y) {
        if (level.isValid(x, y, SPRITE_BOX_WIDTH, SPRITE_BOX_HEIGHT)){
            this.x = x;
            this.y = y;
        }
    }

    public void display(Graphics graphics, Renderer renderer) {
        this.interact(this.x+this.vx, this.y+this.vy);
        this.vx = this.vy = 0;

        graphics.drawImage(this.sprite.getBuffer(), this.getX(), this.getY(), null);
    }

    public void move(String direction) {
        switch (direction) {
            case "up":
                this.vy = -5;
                break;
            case "down":
                this.vy = 5;
                break;
            case "right":
                this.vx = 5;
                break;
            case "left":
                this.vx = -5;
                break;
            default:
                break;
        }
    }
}
