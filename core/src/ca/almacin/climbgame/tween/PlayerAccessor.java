package ca.almacin.climbgame.tween;

import aurelienribon.tweenengine.TweenAccessor;
import ca.almacin.climbgame.sprites.Player;

/**
 * Created by AldrinJerome on 2016-02-12.
 */
public class PlayerAccessor implements TweenAccessor<Player> {
    public static final int MOVEX = 0;
    public static final int JUMP = 1;

    @Override
    public int getValues(Player target, int tweenType, float[] returnValues) {
        switch(tweenType) {
            case MOVEX:
                returnValues[0] = target.getX();
                return 1;
            case JUMP:
                returnValues[0] = target.getY();
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Player target, int tweenType, float[] newValues) {
        switch(tweenType) {
            case MOVEX:
                target.setX(newValues[0]);
                break;
            case JUMP:
                target.setY(newValues[0]);
                break;
            default:
                assert false;
        }
    }
}
