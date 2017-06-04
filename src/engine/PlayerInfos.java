package engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Damien on 04/06/2017.
 */
public class PlayerInfos {

    private int health;
    private int vx;
    private int vy;
    private Dimension position;
    private ArrayList<String> inventory;

    public PlayerInfos() {
        this.health = 5;
        this.vx = 0;
        this.vy = 0;

        this.position = new Dimension(0, 0);
    }

    public void setPosition(Dimension position) {
        this.position = position;
    }

    public Dimension getPosition() {
        return this.position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
}
