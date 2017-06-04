package engine;

import utils.Sprite;
import utils.SpriteFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Damien on 03/06/2017.
 */

enum SpriteType {
    PLAYER, BLOC, MONSTER, OBJECT, PRINCESS
}

public class Renderer {

    int width,
        height;

    HashMap<String, Sprite> sprites;

    private Level level;
    private UserInterface ui;
    private Player player;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;

        this.sprites = new HashMap<>();
        this.level = null;
        this.ui = null;
        this.player = null;
    }

    public void loadSprites(ArrayList<SpriteFile> spriteList) {
        for (SpriteFile file : spriteList) {
             this.sprites.put(file.getBaseName(), new Sprite(file).load());
        }

        System.out.println(this.sprites);
    }

    public void addSprite(SpriteType type) {

    }

    public void render(Graphics graphics) {
        if (this.level != null) {
            this.level.display(graphics, this);
        }
        if (this.ui != null) {
            this.ui.display(graphics, this);
        }
        if (this.player != null) {
            this.player.display(graphics, this);
        }
    }

    public void render(Graphics graphics, Level level) {
        this.level = level;
        this.render(graphics);
    }

    public void render(Graphics graphics, UserInterface ui) {
        this.ui = ui;
        this.render(graphics);
    }

    public void render(Graphics graphics, Player player) {
        this.player = player;
        this.render(graphics);
    }

    // STATIC
    public BufferedImage getSpriteImage(String sprite) {
        if (this.sprites.containsKey(sprite)) {
            return this.sprites.get(sprite).getBuffer();
        }
        return null;
    }

    public Sprite getSprite(String sprite) {
        if (this.sprites.containsKey(sprite)) {
            return this.sprites.get(sprite);
        }
        return null;
    }

    public Level getLevel() { return this.level; }
}
