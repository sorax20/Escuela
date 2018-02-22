package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by jrs on 21/02/18.
 */

public class Hud {
    public final Viewport viewport;
    final BitmapFont font;

    public Hud() {
        this.viewport = new ExtendViewport(Constants.SIZE_MAP2, Constants.SIZE_MAP2);
        font = new BitmapFont();
        font.getData().setScale(3);
    }

    public void render(SpriteBatch batch, long time) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
    //    batch.begin();

        final String hudString ="Time left: "+time;

        font.draw(batch, hudString, Constants.SIZE_MAP2/2+50, viewport.getWorldHeight() - 10);

  //      batch.end();
    }
}
