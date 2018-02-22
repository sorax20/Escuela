package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by jrs on 15/02/18.
 */

public class Victory
{
    Viewport viewport;
    final BitmapFont font;

    public Victory() {
        this.viewport = new ExtendViewport(100, 100);

        font = new BitmapFont();
        font.getData().setScale(2);
    }

    public void init() {
    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        // TODO: Draw a victory message

        font.draw(batch, "YOU WIN", 200,200, 0, Align.center, false);

        batch.end();

    }
}
