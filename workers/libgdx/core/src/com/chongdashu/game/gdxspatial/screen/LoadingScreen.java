package com.chongdashu.game.gdxspatial.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.chongdashu.game.gdxspatial.GdxSpatialGame;
import com.chongdashu.game.gdxspatial.asset.Assets;
import com.chongdashu.game.gdxspatial.spatialos.WorkerConnection;

import java.io.IOException;

public class LoadingScreen extends ScreenAdapter {

    private final GdxSpatialGame game;
    private final OrthographicCamera guiCam;

    public LoadingScreen(GdxSpatialGame game) throws IOException {
        this.game = game;

        guiCam = new OrthographicCamera(1920, 1080);
        guiCam.position.set(1920 / 2, 1080 / 2, 0);

        WorkerConnection.connect();
    }

    @Override
    public void render(float delta) {
        Update();
        Draw();
    }

    protected void Update() {
        if (WorkerConnection.isConnectionAttemptCompleted())
        {
            if (WorkerConnection.isConnectedToSpatialOS()) {
                game.setScreen(new MainMenuScreen(game));
                return;
            }
            else {
                System.out.println("Exiting game...");
                Gdx.app.exit();
                return;
            }
        }
    }

    protected void Draw() {

        // GL
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
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
