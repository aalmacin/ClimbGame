package ca.almacin.climbgame.tween;

import aurelienribon.tweenengine.TweenAccessor;
import ca.almacin.climbgame.sprites.Parallax;
import ca.almacin.climbgame.sprites.Player;

/**
 * Created by AldrinJerome on 2016-02-13.
 */
public class ParallaxAccessor implements TweenAccessor<Parallax> {
    public static final int MAIN = 0;


    @Override
    public int getValues(Parallax target, int tweenType, float[] returnValues) {
        switch(tweenType) {
            case MAIN:
                returnValues[0] = target.getY();
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Parallax target, int tweenType, float[] newValues) {
        switch(tweenType) {
            case MAIN:
                target.setY(newValues[0]);
                break;
            default:
                assert false;
        }
    }
}
