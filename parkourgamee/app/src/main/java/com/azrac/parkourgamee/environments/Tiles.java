package com.azrac.parkourgamee.environments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.azrac.parkourgamee.main.MainActivity;
import com.azrac.parkourgamee.R;
import com.azrac.parkourgamee.helpers.GameConstants;
import com.azrac.parkourgamee.helpers.interfaces.BitmapMethods;

public enum Tiles implements BitmapMethods {

    OUTSIDE(R.drawable.tileset_floor, 22, 26),
    INSIDE(R.drawable.floor_inside, 22, 22);

    private Bitmap[] sprites;

    Tiles(int resID, int tilesInWidth, int tilesInHeight) {
        options.inScaled = false;
        sprites = new Bitmap[tilesInHeight * tilesInWidth];
        Bitmap spriteSheet = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), resID, options);
        for (int j = 0; j < tilesInHeight; j++)
            for (int i = 0; i < tilesInWidth; i++) {
                int index = j * tilesInWidth + i;
                sprites[index] = getScaledBitmap(Bitmap.createBitmap(spriteSheet, GameConstants.Sprite.DEFAULT_SIZE * i, GameConstants.Sprite.DEFAULT_SIZE * j, GameConstants.Sprite.DEFAULT_SIZE, GameConstants.Sprite.DEFAULT_SIZE));
            }

    }

    public Bitmap getSprite(int id) {
        return sprites[id];
    }

}