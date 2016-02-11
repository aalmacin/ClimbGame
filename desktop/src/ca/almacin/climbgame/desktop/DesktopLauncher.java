package ca.almacin.climbgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ca.almacin.climbgame.ClimbGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ClimbGame.SCREEN_WIDTH;
		config.height = ClimbGame.SCREEN_HEIGHT;
		config.title = ClimbGame.TITLE;
		new LwjglApplication(new ClimbGame(), config);
	}
}
