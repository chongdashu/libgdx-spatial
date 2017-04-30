package com.chongdashu.game.gdxspatial.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.chongdashu.game.gdxspatial.GdxSpatialGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "libGDX (SpatialOS) Game";
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new GdxSpatialGame(), config);
	}
}
