package ca.almacin.climbgame.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;
import ca.almacin.climbgame.ClimbGame;
import ca.almacin.climbgame.sprites.Parallax;
import ca.almacin.climbgame.sprites.Player;
import ca.almacin.climbgame.tween.ParallaxAccessor;
import ca.almacin.climbgame.tween.PlayerAccessor;


/**
 * Created by AldrinJerome on 2016-02-12.
 */
public class PlayScreen extends ClimbScreen {
    private static final int JUMP_HEIGHT = 100;

    private static final int JUMP_LEFT = 0;
    private static final int JUMP_RIGHT = 1;
    private static final int JUMP_UP = 2;
    private static final int JUMP_DOWN = 3;
    private static final float JUMP_SPEED = 0.2f;

    private final Player player;
    private final TweenManager tweenManager;
    private final TextureAtlas.AtlasRegion jumpLeftTexture;
    private final TextureAtlas.AtlasRegion jumpRightTexture;
    private final OrthographicCamera orthographicCamera;
    private final FillViewport viewport;
    private Parallax parallax;
    private TextureRegion playerTexture;
    private float touchX;
    private float touchY;
    private int movement;

    public PlayScreen(ClimbGame game) {
        super(game, "Background", "Play.pack");
        this.player = new Player();
        this.parallax = new Parallax(this.background);
        this.tweenManager = new TweenManager();

        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, ClimbGame.SCREEN_WIDTH, ClimbGame.SCREEN_HEIGHT * 0.25f );

        this.viewport = new FillViewport(ClimbGame.SCREEN_WIDTH, ClimbGame.SCREEN_HEIGHT);
        this.viewport.setScreenPosition(ClimbGame.SCREEN_WIDTH / 2, (ClimbGame.SCREEN_HEIGHT / 4));

        this.orthographicCamera.position.set(this.viewport.getScreenX(), this.viewport.getScreenY(), 0);
        this.viewport.setCamera(this.orthographicCamera);


        this.jumpLeftTexture = textureAtlas.findRegion("JumpLeft");
        this.jumpRightTexture = textureAtlas.findRegion("JumpRight");

        movement = JUMP_LEFT;

        Tween.set(this.parallax, ParallaxAccessor.MAIN).target(this.parallax.getY()).start(tweenManager);

        Tween.to(this.parallax, ParallaxAccessor.MAIN, 3.0f).target(-(ClimbGame.SCREEN_HEIGHT / 2)).repeat(-1, 0).start(tweenManager);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.tweenManager.update(delta);

        this.orthographicCamera.update();


        this.game.getBatch().setProjectionMatrix(this.orthographicCamera.combined);

        this.game.getBatch().begin();
        this.game.getBatch().draw(this.parallax.getBackground(), 0, this.parallax.getY());


        if(tweenManager.getRunningTweensCount() > 1) {
            if(movement == JUMP_LEFT)
                this.game.getBatch().draw(this.textureAtlas.findRegion("JumpLeft"), this.player.getX(), this.player.getY());
            else if (movement == JUMP_RIGHT)
                this.game.getBatch().draw(this.textureAtlas.findRegion("JumpRight"), this.player.getX(), this.player.getY());
            else if (movement == JUMP_UP)
                this.game.getBatch().draw(this.textureAtlas.findRegion("JumpUp"), this.player.getX(), this.player.getY());
            else if (movement == JUMP_DOWN)
                this.game.getBatch().draw(this.textureAtlas.findRegion("JumpDown"), this.player.getX(), this.player.getY());
        } else {
            this.playerTexture = this.player.getCurrentFrame(delta);
            this.game.getBatch().draw(this.playerTexture, this.player.getX(), this.player.getY());
        }

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
        this.touchX = screenX;
        this.touchY = screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(Math.abs(screenX - this.touchX) > 75 &&
                !(this.player.getCurrentPos() == Player.LEFTMOST && this.touchX > screenX) &&
                !(this.player.getCurrentPos() == Player.RIGHTMOST && this.touchX < screenX)) {
            if(this.touchX > screenX) {
                this.player.moveLeft();
                this.movement = JUMP_LEFT;
            } else {
                this.player.moveRight();
                this.movement = JUMP_RIGHT;
            }

            // Start the jump
            Tween.set(this.player, PlayerAccessor.MOVE_X).target(this.player.getX()).start(tweenManager);
            Tween.to(this.player, PlayerAccessor.MOVE_X, 0.2f).target(this.player.getNewX()).start(tweenManager);

        } else if(Math.abs(screenY - this.touchY) > 75) {

            Tween.set(this.player, PlayerAccessor.JUMP).target(this.player.getY()).start(tweenManager);

            if(screenY < this.touchY) {
                Timeline.createParallel()
                        .push(Tween.to(this.player, PlayerAccessor.JUMP, JUMP_SPEED).target(Player.PLAYER_POSITION_Y + JUMP_HEIGHT))
                        .push(Tween.to(this.player, PlayerAccessor.JUMP, JUMP_SPEED).delay(JUMP_SPEED).target(this.player.getY()))
                        .start(tweenManager);

                this.movement = JUMP_UP;

            } else {
                Timeline.createParallel()
                        .push(Tween.to(this.player, PlayerAccessor.JUMP, JUMP_SPEED).target(Player.PLAYER_POSITION_Y - JUMP_HEIGHT))
                        .push(Tween.to(this.player, PlayerAccessor.JUMP, JUMP_SPEED).delay(JUMP_SPEED).target(this.player.getY()))
                        .start(tweenManager);

                this.movement = JUMP_DOWN;
            }
        }
        return false;
    }
}
