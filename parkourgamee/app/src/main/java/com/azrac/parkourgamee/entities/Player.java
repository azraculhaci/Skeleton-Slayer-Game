package com.azrac.parkourgamee.entities;

import static com.azrac.parkourgamee.main.MainActivity.GAME_HEIGHT;
import static com.azrac.parkourgamee.main.MainActivity.GAME_WIDTH;

import android.graphics.PointF;

public class Player extends Character {


    public Player() {
        super(new PointF(GAME_WIDTH / 2, GAME_HEIGHT / 2), GameCharacters.PLAYER);
    }

    public void update(double delta, boolean movePlayer) {
        if (movePlayer)
            updateAnimation();
        updateWepHitbox();
    }


}