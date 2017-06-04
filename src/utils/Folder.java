package utils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Damien on 03/06/2017.
 */
public class Folder {

    String path;
    File folder;

    public Folder(String folderPath) {
        this.path = folderPath;

        this.folder = new File(this.path);
    }

    public ArrayList<SpriteFile> list() {
        ArrayList<SpriteFile> list = new ArrayList<>();

        this._list(this.folder.getAbsolutePath(), list);

        return list;
    }

    private void _list(String path, ArrayList<SpriteFile> list) {
        File directory = new File(path);

        try {
            File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isFile()) {
                    list.add(new SpriteFile(file.getAbsolutePath()));
                } else if (file.isDirectory()) {
                    _list(file.getAbsolutePath(), list);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
