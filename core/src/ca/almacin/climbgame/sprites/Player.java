package ca.almacin.climbgame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ca.almacin.climbgame.ClimbGame;

/**
 * Created by AldrinJerome on 2016-02-12.
 */
public class Player extends Sprite {
    public static final int LEFTMOST = -2;
    public static final int CENTRE = 0;
    public static final int RIGHTMOST = 2;
    private final int CLIMB_MAN_WIDTH;
    private final int PLAYER_INITIAL_X;

    private final TextureAtlas textureAtlas;
    private final Animation animation;

    private int currentPos;
    private float stateTime;

    public Player() {
        textureAtlas = new TextureAtlas(Gdx.files.internal("Climb.pack"));
        animation = new Animation(0.5f, textureAtlas.getRegions());

        CLIMB_MAN_WIDTH = animation.getKeyFrame(0, true).getRegionWidth();
        PLAYER_INITIAL_X = (ClimbGame.SCREEN_WIDTH / 2) - (CLIMB_MAN_WIDTH / 2);

        stateTime = 0.0f;
        currentPos = CENTRE;
        this.move();
    }

    public TextureRegion getCurrentFrame(float delta) {
        stateTime += delta;
        return animation.getKeyFrame(stateTime, true);
    }

    public void moveLeft() {
        currentPos--;
        if(currentPos < LEFTMOST ) currentPos = LEFTMOST;
        this.move();
    }

    public void moveRight() {
        currentPos++;
        if(currentPos > RIGHTMOST ) currentPos = RIGHTMOST;
        this.move();
    }
    
    private void move() {
        this.setX(this.PLAYER_INITIAL_X + (this.currentPos * this.CLIMB_MAN_WIDTH));
    }
}
