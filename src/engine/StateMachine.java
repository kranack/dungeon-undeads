package engine;


import java.awt.event.KeyEvent;

enum KEY_EVENTS {
    MENU_EVENT, GAME_EVENT, HELP_EVENT, WIN_EVENT, LOSE_EVENT, QUIT_EVENT
}

/**
 * Created by Damien on 04/06/2017.
 */
public class StateMachine {

    GAME_DISPLAY_STATE state;

    public StateMachine(GAME_DISPLAY_STATE state) {
        this.state = state;
    }

    public boolean next(GAME_DISPLAY_STATE state) {
        boolean isValid = state != null && this.restrict(state);
        if (isValid) {
            this.state = state;
        }

        return isValid;
    }

    public boolean next(String eventType, KeyEvent e) {
        GAME_DISPLAY_STATE nextState;

        switch(eventType) {
            case "press":
            default:
                nextState = this.getNextStateFromKeyPress(e);
                break;
        }

        return this.next(nextState);
    }

    public GAME_DISPLAY_STATE getState() {
        return this.state;
    }

    private boolean restrict(GAME_DISPLAY_STATE state) {
        boolean isValid = true;

        switch (this.state) {
            case DISPLAY_HELP:
                isValid = !(state == GAME_DISPLAY_STATE.DISPLAY_WIN || state == GAME_DISPLAY_STATE.DISPLAY_LOSE || state == GAME_DISPLAY_STATE.DISPLAY_GAME);
                break;
            case DISPLAY_LOSE:
            case DISPLAY_WIN:
                isValid = (state == GAME_DISPLAY_STATE.DISPLAY_MENU);
                break;
            case DISPLAY_GAME:
                isValid = !(state == GAME_DISPLAY_STATE.DISPLAY_HELP);
                break;
            case DISPLAY_MENU:
            default:
                isValid = !(state == GAME_DISPLAY_STATE.DISPLAY_WIN || state == GAME_DISPLAY_STATE.DISPLAY_LOSE);
                break;
        }

        return isValid;
    }

    private GAME_DISPLAY_STATE getNextStateFromKeyPress(KeyEvent e) {
        GAME_DISPLAY_STATE nextState;

        switch (e.getKeyCode()) {
            case 83: // S
            case 13: // Enter
                nextState = (this.state == GAME_DISPLAY_STATE.DISPLAY_MENU) ? GAME_DISPLAY_STATE.DISPLAY_GAME : null;
                break;
            case 32: // Space
                nextState = (this.state == GAME_DISPLAY_STATE.DISPLAY_MENU) ? GAME_DISPLAY_STATE.DISPLAY_GAME : null;
                break;
            case 72: // H
                nextState = (this.state == GAME_DISPLAY_STATE.DISPLAY_MENU) ? GAME_DISPLAY_STATE.DISPLAY_HELP :
                            ((this.state == GAME_DISPLAY_STATE.DISPLAY_HELP) ? GAME_DISPLAY_STATE.DISPLAY_MENU : null);
                break;
            case 27: // Esc
                nextState = (this.state == GAME_DISPLAY_STATE.DISPLAY_GAME) ? GAME_DISPLAY_STATE.DISPLAY_MENU :
                            ((this.state == GAME_DISPLAY_STATE.DISPLAY_MENU) ? GAME_DISPLAY_STATE.DISPLAY_QUIT : null);
                break;
            default:
                nextState = null;
                break;
        }

        return nextState;
    }
}
