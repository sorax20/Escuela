package com.mygdx.game.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Level;
import com.mygdx.game.util.Assets;
import com.mygdx.game.util.Constants;

/**
 * Created by jrs on 19/01/18.
 */

public class Enemy
{
    Vector2 position;
    Level level;

    public Enemy(Level level)
    {
        this.level=level;
        position=new Vector2(MathUtils.random(0, Constants.SIZE_MAP2),Constants.SIZE_MAP2);
    }

    public void update(float delta)
    {
        position.y-=delta*Constants.ENEMY_SPEED;
        if(position.y<=0)level.reset();
    }

    public void render(SpriteBatch batch) {
        final TextureRegion region = Assets.instance.enemyAssets.enemy;
        //Utils.drawTextureRegion(batch, region, position, Constants.ENEMY_CENTER);
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
