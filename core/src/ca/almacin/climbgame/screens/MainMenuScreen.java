package ca.almacin.climbgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

import ca.almacin.climbgame.ClimbGame;

/**
 * Created by AldrinJerome on 2016-02-07.
 */
public class MainMenuScreen extends ClimbScreen {
    private static final int BUTTON_VERTICAL_SPACE = 10;

    private final TextureAtlas.AtlasRegion playButtonUp;
    private final TextureAtlas.AtlasRegion playButtonDown;
    private final TextureAtlas.AtlasRegion optionsButtonUp;
    private final TextureAtlas.AtlasRegion optionsButtonDown;

    private final int buttonX;
    private final int playButtonY;
    private final int optionsButtonY;

    private final Rectangle playButtonRect;
    private final Rectangle optionsButtonRect;

    private TextureAtlas.AtlasRegion playButton;
    private TextureAtlas.AtlasRegion optionsButton;

    public MainMenuScreen(ClimbGame game) {
        super(game, "Background", "MainMenu.pack");

        playButtonUp = this.textureAtlas.findRegion("Play");
        playButtonDown = this.textureAtlas.findRegion("PlayDown");

        optionsButtonUp = this.textureAtlas.findRegion("Options");
        optionsButtonDown = this.textureAtlas.findRegion("OptionsDown");

        this.playButton = this.playButtonUp;
        this.optionsButton = this.optionsButtonUp;

        this.buttonX = (ClimbGame.SCREEN_WIDTH / 2) - (this.playButton.getRegionWidth() / 2);

        this.playButtonY = (ClimbGame.SCREEN_HEIGHT / 3) + (this.playButton.getRegionHeight());
        this.optionsButtonY = this.playButtonY - (this.optionsButton.getRegionHeight() + BUTTON_VERTICAL_SPACE);

        playButtonRect = new Rectangle(this.buttonX, this.playButtonY, this.playButton.getRegionWidth(), this.playButton.getRegionHeight());
        optionsButtonRect = new Rectangle(this.buttonX, this.optionsButtonY, this.optionsButton.getRegionWidth(), this.optionsButton.getRegionHeight());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.game.getBatch().begin();
        this.game.getBatch().draw(this.background, 0, 0);


        this.game.getBatch().draw(this.playButton,
                this.buttonX,
                this.playButtonY);

        this.game.getBatch().draw(this.optionsButton,
                this.buttonX,
                this.optionsButtonY);

        this.game.getBatch().end();
    }

    @Override
    public void update() {

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
        screenY = Math.abs(ClimbGame.SCREEN_HEIGHT - screenY);

        if(this.playButtonRect.overlaps(new Rectangle(screenX, screenY, 1, 1))) {
            this.playButton = this.playButtonDown;
        }

        if(this.optionsButtonRect.overlaps(new Rectangle(screenX, screenY, 1, 1))) {
            this.optionsButton = this.optionsButtonDown;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenY = Math.abs(ClimbGame.SCREEN_HEIGHT - screenY);

        this.playButton = this.playButtonUp;
        this.optionsButton = this.optionsButtonUp;

        if(this.playButtonRect.overlaps(new Rectangle(screenX, screenY, 1, 1))) {
            this.game.setScreen(new PlayScreen(this.game));
            this.dispose();
        }

        if(this.optionsButtonRect.overlaps(new Rectangle(screenX, screenY, 1, 1))) {
            this.game.setScreen(new OptionsScreen(this.game));
            this.dispose();
        }
        return false;
    }


}
