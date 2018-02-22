package com.mygdx.game.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.Assets;

/**
 * Created by jrs on 15/02/18.
 */

public class Platform
{

    public final float top;
    public final float bottom;
    public final float left;
    public final float right;
    // This is used by the level loading code to link enemies and platforms.
    String identifier;

    public Platform(float left, float top, float width, float height) {
        this.top = top;
        this.bottom = top - height;
        this.left = left;
        this.right = left + width;
    }

    public void render(SpriteBatch batch) {
        final float width = right - left;
        final float height = top - bottom;
        Assets.instance.platformAssets.platform.draw(batch, left - 1, bottom - 1, width + 2, height + 2);
    }
}
