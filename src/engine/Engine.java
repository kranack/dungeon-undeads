package engine;

import utils.Folder;
import utils.SpriteFile;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Damien on 03/06/2017.
 */
public class Engine {

    private Dimension dimension;
    private Renderer renderer;

    public Engine(Dimension dimension) {
        this.dimension = dimension;
        this.renderer = new Renderer(this.dimension.width, this.dimension.height);
    }

    public void loadSprites(String folderPath) {
        Folder folder = new Folder(folderPath);

        ArrayList<SpriteFile> spriteList = folder.list();
        this.renderer.loadSprites(spriteList);
    }

    public void addSprite(SpriteType type) {
        this.renderer.addSprite(type);
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics);
    }

    public void renderLevel(Graphics graphics, Level level) { this.renderer.render(graphics, level); }

    public void renderUI(Graphics graphics, UserInterface ui) { this.renderer.render(graphics, ui); }

    public void renderPlayer(Graphics graphics, Player player) { this.renderer.render(graphics, player); }
}
