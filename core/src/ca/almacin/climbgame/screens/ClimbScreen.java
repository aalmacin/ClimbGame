package ca.almacin.climbgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ca.almacin.climbgame.ClimbGame;

/**
 * Created by AldrinJerome on 2016-02-08.
 */
public abstract class ClimbScreen implements Screen, InputProcessor {
    protected ClimbGame game;
    protected TextureAtlas.AtlasRegion background;

    protected final TextureAtlas textureAtlas;

    public ClimbScreen(ClimbGame game, String background, String atlas) {
        this.game = game;

        this.textureAtlas = new TextureAtlas(Gdx.files.internal(atlas));

        this.background = textureAtlas.findRegion(background);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();
    }


    protected abstract void update();

    @Override
    public abstract void show();

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();

    // Input Processor
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);

    @Override
    public abstract boolean touchUp(int screenX, int screenY, int pointer, int button);

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
