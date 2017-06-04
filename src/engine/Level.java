package engine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Damien on 04/06/2017.
 */
public class Level {

    String levelName;
    File levelFile;
    JSONArray backgrounds;
    JSONArray rows;

    public Level(String levelName) {
        this.levelName = levelName;
        this.rows = null;
        this.backgrounds = null;

        this.levelFile = new File("Ressources/levels/" + levelName + ".json");

        this.load();
    }

    public void display(Graphics graphics, Renderer renderer) {
        this.renderBackgrounds(graphics, renderer);
        this.renderBlocs(graphics, renderer);

    }

    private void renderBackgrounds(Graphics graphics, Renderer renderer) {
        // Rien à afficher
        if (this.backgrounds == null) { return; }

        Iterator<String> bgIt = this.backgrounds.iterator();
        while(bgIt.hasNext()) {
            String background = bgIt.next();
            graphics.drawImage(renderer.getSpriteImage(background), 0, 0, null);
        }
    }

    private void renderBlocs(Graphics graphics, Renderer renderer) {
        int i = 0;
        int j = 0;

        // Rien à afficher
        if (this.rows == null) { return; }

        Iterator<JSONObject> rowIt = this.rows.iterator();
        while (rowIt.hasNext()) {
            JSONObject row = rowIt.next();
            JSONArray blocs = (JSONArray) row.get("blocs");
            Iterator<Long> blocIt = blocs.iterator();

            j = 0;
            while (blocIt.hasNext()) {
                Long blocID = blocIt.next();
                if (blocID == 0) {
                    //graphics.drawRect(j*100,i*100,100,100);
                }
                //cube herbeux = 1
                if (blocID == 1) {
                    graphics.drawImage(renderer.getSpriteImage("cube1"), j * 50, i * 50, null);
                }
                //cube pierre = 2
                if (blocID == 2) {
                    graphics.drawImage(renderer.getSpriteImage("wall"), j * 50, i * 50, null);
                }
                //cube porte = 3
                if (blocID == 3) {
                    graphics.drawImage(renderer.getSpriteImage("door"), j * 50, i * 50, null);
                }
                //cube terre = 4
                if (blocID == 4) {
                    graphics.drawImage(renderer.getSpriteImage("cube_under1"), j * 50, i * 50, null);
                }
                //pierre cave = 5
                if (blocID == 5) {
                    graphics.drawImage(renderer.getSpriteImage("cave"), j * 50, i * 50, null);
                }
                //pics = 6
                if (blocID == 6) {
                    graphics.drawImage(renderer.getSpriteImage("pics"), j * 50, i * 50, null);
                }
                j++;
            }
            i++;
        }
    }

    public boolean isValid(int x, int y, int tx, int ty) {
        int i,j;
        boolean isValid = true;
        int idebut = y/50;
        int ifin = (y+ty)/50;
        int jdebut = x/50;
        int jfin = (x+tx)/50;

        JSONObject firstRow = (JSONObject) this.rows.get(0);
        JSONArray firstRowBlocs = (JSONArray) firstRow.get("blocs");
        if (x <0 || y<0 || y>=480 || x>50*(firstRowBlocs.size()-1)){
            return false;
        }
        for (i=idebut;i<=ifin;++i){
            for (j=jdebut;j<=jfin;++j) {
                JSONObject row = (JSONObject) this.rows.get(i);
                JSONArray blocs = (JSONArray) row.get("blocs");
                Long blocID = (Long) blocs.get(j);
                if (blocID != 0) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    private void load() {
        JSONParser parser = new JSONParser();

        try {
            JSONObject root = (JSONObject) parser.parse(new FileReader(this.levelFile));

            this.rows = (JSONArray) root.get("rows");
            this.backgrounds = (JSONArray) root.get("backgrounds");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
