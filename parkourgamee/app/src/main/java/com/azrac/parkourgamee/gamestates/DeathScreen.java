package com.azrac.parkourgamee.gamestates;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.azrac.parkourgamee.helpers.interfaces.GameStateInterface;
import com.azrac.parkourgamee.main.Game;
import com.azrac.parkourgamee.main.MainActivity;
import com.azrac.parkourgamee.ui.ButtonImages;
import com.azrac.parkourgamee.ui.CustomButton;
import com.azrac.parkourgamee.ui.GameImages;

public class DeathScreen extends BaseState implements GameStateInterface {

    private CustomButton btnReplay, btnMainMenu;

    private int menuX = MainActivity.GAME_WIDTH / 6;
    private int menuY = 200;

    private int buttonsX = menuX + GameImages.DEATH_MENU_MENUBG.getImage().getWidth() / 2 - ButtonImages.MENU_START.getWidth() / 2;
    private int btnReplayY = menuY + 200, btnMainMenuY = btnReplayY + 150;


    public DeathScreen(Game game) {
        super(game);
        btnReplay = new CustomButton(buttonsX, btnReplayY, ButtonImages.MENU_REPLAY.getWidth(), ButtonImages.MENU_REPLAY.getHeight());
        btnMainMenu = new CustomButton(buttonsX, btnMainMenuY, ButtonImages.MENU_MENU.getWidth(), ButtonImages.MENU_MENU.getHeight());
    }


    @Override
    public void render(Canvas c) {
        drawBackground(c);
        drawButtons(c);
    }

    private void drawButtons(Canvas c) {
        c.drawBitmap(ButtonImages.MENU_REPLAY.getBtnImg(btnReplay.isPushed()),
                btnReplay.getHitbox().left,
                btnReplay.getHitbox().top,
                null);

        c.drawBitmap(ButtonImages.MENU_MENU.getBtnImg(btnMainMenu.isPushed()),
                btnMainMenu.getHitbox().left,
                btnMainMenu.getHitbox().top,
                null);
    }

    private void drawBackground(Canvas c) {
        c.drawBitmap(GameImages.DEATH_MENU_MENUBG.getImage(),
                menuX, menuY, null);
    }

    @Override
    public void touchEvents(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isIn(event, btnReplay))
                btnReplay.setPushed(true);
            else if (isIn(event, btnMainMenu))
                btnMainMenu.setPushed(true);

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (isIn(event, btnReplay)) {
                if (btnReplay.isPushed())
                    game.setCurrentGameState(Game.GameState.PLAYING);
            } else if (isIn(event, btnMainMenu)) {
                if (btnMainMenu.isPushed())
                    game.setCurrentGameState(Game.GameState.MENU);
            }

            btnReplay.setPushed(false);
            btnMainMenu.setPushed(false);
        }

    }


    @Override
    public void update(double delta) {
    }

}