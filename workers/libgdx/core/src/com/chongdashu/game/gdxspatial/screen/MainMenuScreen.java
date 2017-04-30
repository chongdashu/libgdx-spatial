package com.chongdashu.game.gdxspatial.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.chongdashu.game.gdxspatial.GdxSpatialGame;
import com.chongdashu.game.gdxspatial.asset.Assets;

public class MainMenuScreen extends ScreenAdapter {

    private final GdxSpatialGame game;
    private final OrthographicCamera guiCam;

    public MainMenuScreen(GdxSpatialGame game) {
        this.game = game;

        guiCam = new OrthographicCamera(1920, 1080);
        guiCam.position.set(1920 / 2, 1080 / 2, 0);
    }

    @Override
    public void render(float delta) {
        Update();
        Draw();
    }

    protected void Update() {

    }

    protected void Draw() {

        // GL
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Camera
        guiCam.update();
        game.spriteBatch.setProjectionMatrix(guiCam.combined);

        // Draw
        game.spriteBatch.disableBlending();
        game.spriteBatch.begin();

        game.spriteBatch.end();

        // Blit
        game.spriteBatch.enableBlending();
        game.spriteBatch.begin();

        game.spriteBatch.draw(Assets.badLogicGamesLogo, 0, 0);

        game.spriteBatch.end();
    }


}
