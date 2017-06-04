package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Damien on 03/06/2017.
 */
public class SpriteFile extends File {

    private static ArrayList<String> spriteExtension = new ArrayList<>(Arrays.asList("png", "jpg", "jpeg"));

    public SpriteFile(String pathname) {
        super(pathname);
    }

    public String getBaseName() {
        String name = this.getName();

        String[] parts = name.split(Pattern.quote("."));
        String ext = parts[parts.length-1];
        if (spriteExtension.contains(ext)) {
            name = name.substring(0, name.lastIndexOf("."));
        }

        return name;
    }
}
