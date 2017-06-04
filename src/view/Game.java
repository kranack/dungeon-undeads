package view;

import engine.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


/**
 * Created by Damien on 04/06/2017.
 */
public class Game {

    Engine engine;
    StateMachine sm;
    Level level;
    UserInterface ui;
    PlayerInfos infos;
    Player player;
    Controller controller;

    public Game(Engine engine) {
        this.engine = engine;
        this.sm = new StateMachine(GAME_DISPLAY_STATE.DISPLAY_MENU);

        this.init();
    }

    private void init() {
        this.infos = new PlayerInfos();
        this.level = new Level("level1");
        this.ui = new UserInterface(this.engine, this.infos);
        this.player = new Player(this.engine);
        this.controller = new Controller(this.player.getSpriteObject());
    }

    public void render(Graphics graphics) {
        if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_MENU) {
            this.displayImage(graphics, "Menu");
        } else if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_GAME) {
            this.engine.renderLevel(graphics, this.level);
            this.engine.renderPlayer(graphics, this.player);
            this.engine.renderUI(graphics, this.ui);
        } else if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_HELP) {
            this.displayImage(graphics, "Menu_help");
        } else if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_WIN) {
            this.displayImage(graphics, "victoire_modif");
        } else if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_LOSE) {
            this.displayImage(graphics, "GameOver");
        }
    }

    public void play() {

    }

    public GAME_DISPLAY_STATE getState() {
        return this.sm.getState();
    }

    public void userPress(KeyEvent e) {
        GAME_DISPLAY_STATE previousState  = this.sm.getState();
        if (this.sm.next("press", e) && previousState == GAME_DISPLAY_STATE.DISPLAY_GAME) {
            this.pause();
        }
        if (this.sm.getState() == GAME_DISPLAY_STATE.DISPLAY_GAME) {
            this.resume();
            this.controller.press(e);
        }
    }

    private void pause() {
        // Pause game
    }

    private void resume() {
        // Resume game
    }

    private void displayImage(Graphics graphics, String image) {
        BufferedImage menu = this.engine.getRenderer().getSpriteImage(image);
        if (menu != null) {
            graphics.drawImage(menu, 150, 0, null);
        } else {
            System.out.println("Asset " + image + " not found!");
        }
    }
}
