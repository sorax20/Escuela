package com.mygdx.game.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Assets;
import com.mygdx.game.util.Constants;

/**
 * Created by jrs on 8/02/18.
 */

public class Shoot {

    //private final Level level;

    // TODO: Add boolean active flag
    public boolean active;

    private Vector2 position;
    private float alturaMundo;

    public Shoot(Vector2 position, float alturaMundo) {
        //this.level = level;
        this.position = position;
        this.alturaMundo=alturaMundo;
        active = true;
    }

    public void update(float delta) {
        position.y += delta * Constants.SHOOT_SPEED;

        if (position.y > alturaMundo)
        {
            active = false;
        }
    }

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.shootAssets.shoot;
        //Utils.drawTextureRegion(batch, region, position, Constants.BULLET_CENTER);
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
    public float getAltura()
    {
        return position.y;
    }
    public Vector2 getPosition(){return position;}
}
