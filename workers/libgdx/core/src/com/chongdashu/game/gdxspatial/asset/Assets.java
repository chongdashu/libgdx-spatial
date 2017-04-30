package com.chongdashu.game.gdxspatial.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by chong-u on 30/04/2017.
 */
public class Assets {

    public static Texture badLogicGamesLogo;

    public static void load() {
        badLogicGamesLogo = loadTexture("badlogic.jpg");
    }

    private static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }
}
