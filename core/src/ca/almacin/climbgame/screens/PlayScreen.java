package ca.almacin.climbgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import ca.almacin.climbgame.ClimbGame;

/**
 * Created by AldrinJerome on 2016-02-12.
 */
public class PlayScreen extends ClimbScreen {
    public PlayScreen(ClimbGame game) {
        super(game, new Texture(Gdx.files.internal("dragon.jpg")));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.game.getBatch().begin();
        this.game.getBatch().draw(this.background, 0, 0);
        this.game.getBatch().end();
    }

    @Override
    protected void update() {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
}
