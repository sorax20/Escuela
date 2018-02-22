package com.mygdx.game.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Assets;

/**
 * Created by jrs on 15/02/18.
 */

public class Goal
{
    Vector2 position;
    public Goal(Vector2 position)
    {
        this.position=position;
    }

    public void render(SpriteBatch batch)
    {
        TextureRegion region=Assets.instance.goalAssets.goal;
        batch.draw(
                region.getTexture(),
                position.x,
                position.y,
                0,
                0,
                region.getRegionWidth(),
                region.getRegionHeight(),
                1,
                1,
                0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false,
                false);
    }

    public Vector2 getPosition(){return position;}
}
