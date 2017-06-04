package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Damien on 03/06/2017.
 */
public class Sprite {

    private File file;
    private BufferedImage buffer;

    public Sprite(File file) {
        this.file = file;
    }

    public Sprite load() {
        try {
            this.buffer = ImageIO.read(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public BufferedImage getBuffer() {
        return this.buffer;
    }
}
