package ca.almacin.climbgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import ca.almacin.climbgame.ClimbGame;

/**
 * Created by AldrinJerome on 2016-02-07.
 */
public class Main extends ScreenWithBackground {
    public Main(ClimbGame game) {
        super(game, new Texture(Gdx.files.internal("badlogic.jpg")));
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        this.game.getBatch().begin();
        this.game.getBatch().draw(this.background, 0, 0);
        this.game.getBatch().end();

    }
}
