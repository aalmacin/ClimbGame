package ca.almacin.climbgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import aurelienribon.tweenengine.Tween;
import ca.almacin.climbgame.screens.MainMenuScreen;
import ca.almacin.climbgame.sprites.Player;
import ca.almacin.climbgame.tween.PlayerAccessor;

public class ClimbGame extends Game {
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 800;
	public static final String TITLE = "ClimbGame";

	private SpriteBatch batch;
	private MainMenuScreen mainMenu;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.mainMenu = new MainMenuScreen(this);
		this.setScreen(mainMenu);



		Tween.registerAccessor(Player.class, new PlayerAccessor());
	}

	@Override
	public void render () {
		super.render();
	}

	public SpriteBatch getBatch() {
		return batch;
	}
}
