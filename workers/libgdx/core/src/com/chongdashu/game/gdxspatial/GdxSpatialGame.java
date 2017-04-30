package com.chongdashu.game.gdxspatial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chongdashu.game.gdxspatial.asset.Assets;
import com.chongdashu.game.gdxspatial.screen.MainMenuScreen;

public class GdxSpatialGame extends Game {
	public SpriteBatch spriteBatch;

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
        Assets.load();
        setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
