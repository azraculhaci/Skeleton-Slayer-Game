package com.azrac.parkourgamee.main;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.azrac.parkourgamee.gamestates.DeathScreen;
import com.azrac.parkourgamee.gamestates.Menu;
import com.azrac.parkourgamee.gamestates.Playing;

public class Game {

    private SurfaceHolder holder;
    private Menu menu;
    private Playing playing;
    private DeathScreen deathScreen;
    private GameLoop gameLoop;
    private GameState currentGameState = GameState.DEATH_SCREEN;

    public Game(SurfaceHolder holder) {
        this.holder = holder;
        gameLoop = new GameLoop(this);
        initGameStates();
    }

    public void update(double delta) {
        switch (currentGameState) {
            case MENU:
                menu.update(delta);
                break;
            case PLAYING:
                playing.update(delta);
                break;
            case DEATH_SCREEN:
                deathScreen.update(delta);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentGameState);
        }
    }

    public void render() {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.BLACK);

        // Draw the game
        switch (currentGameState) {
            case MENU:
                menu.render(c);
                break;
            case PLAYING:
                playing.render(c);
                break;
            case DEATH_SCREEN:
                deathScreen.render(c);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentGameState);
        }

        holder.unlockCanvasAndPost(c);
    }

    private void initGameStates() {
        menu = new Menu(this);
        playing = new Playing(this);
        deathScreen = new DeathScreen(this);
    }

    public boolean touchEvent(MotionEvent event) {
        switch (currentGameState) {
            case MENU:
                menu.touchEvents(event);
                break;
            case PLAYING:
                playing.touchEvents(event);
                break;
            case DEATH_SCREEN:
                deathScreen.touchEvents(event);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentGameState);
        }

        return true;
    }


    public void startGameLoop() {
        gameLoop.startGameLoop();
    }

    public enum GameState {
        MENU, PLAYING, DEATH_SCREEN;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public DeathScreen getDeathScreen() {
        return deathScreen;
    }
}