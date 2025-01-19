package com.azrac.parkourgamee.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.azrac.parkourgamee.R;
import com.azrac.parkourgamee.helpers.interfaces.BitmapMethods;
import com.azrac.parkourgamee.main.MainActivity;

public enum GameImages implements BitmapMethods {


    MAINMENU_MENUBG(R.drawable.mainmenu_menubackground),
    DEATH_MENU_MENUBG(R.drawable.menu_youdied_background);

    private final Bitmap image;

    GameImages(int resID) {
        options.inScaled = false;
        image = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), resID, options);
    }

    public Bitmap getImage() {
        return image;
    }
}