package ca.almacin.climbgame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by AldrinJerome on 2016-02-13.
 */
public class Parallax {
    private float y;
    private TextureAtlas.AtlasRegion background;

    public Parallax(TextureAtlas.AtlasRegion background) {
        this.background = background;
        this.y = 0;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public TextureAtlas.AtlasRegion getBackground() {
        return background;
    }
}
