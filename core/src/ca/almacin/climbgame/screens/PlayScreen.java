package ca.almacin.climbgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import aurelienribon.tweenengine.Tween;

import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenManager;
import ca.almacin.climbgame.ClimbGame;
import ca.almacin.climbgame.sprites.Player;
import ca.almacin.climbgame.tween.PlayerAccessor;

/**
 * Created by AldrinJerome on 2016-02-12.
 */
public class PlayScreen extends ClimbScreen {
    private static final int PLAYER_POSITION_Y = ClimbGame.SCREEN_HEIGHT / 2 - 200;
    private final Player player;
    private final TweenManager tweenManager;
    private TextureRegion playerTexture;
    private float touchDown;

    public PlayScreen(ClimbGame game) {
        super(game, new Texture(Gdx.files.internal("cliff.png")));
        this.player = new Player();
        this.tweenManager = new TweenManager();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.tweenManager.update(delta);
        this.game.getBatch().begin();
        this.game.getBatch().draw(this.background, 0, 0);
        this.playerTexture = this.player.getCurrentFrame(delta);
        this.game.getBatch().draw(this.playerTexture, this.player.getX(), PLAYER_POSITION_Y);
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
        this.touchDown = screenX;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(this.touchDown > screenX) {
            this.player.moveLeft();
        } else {
            this.player.moveRight();
        }

        // Start the jump
        Tween.set(this.player, PlayerAccessor.MOVEX).target(this.player.getX()).start(tweenManager);
        Tween.to(this.player, PlayerAccessor.MOVEX, 0.2f).target(this.player.getNewX()).start(tweenManager);
        return false;
    }
}
