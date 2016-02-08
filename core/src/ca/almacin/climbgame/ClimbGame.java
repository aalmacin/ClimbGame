package ca.almacin.climbgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ca.almacin.climbgame.screens.Main;

public class ClimbGame extends Game {
	private SpriteBatch batch;
	private Main mainMenu;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.mainMenu = new Main(this);
		this.setScreen(mainMenu);
	}

	@Override
	public void render () {
		super.render();
	}

	public SpriteBatch getBatch() {
		return batch;
	}
}
