package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by jrs on 19/01/18.
 */

public class Assets implements Disposable, AssetErrorListener
{
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;
    public StickmanAssets stickmanAssets;
    public ShootAssets shootAssets;
    public EnemyAssets enemyAssets;
    public GoalAssets goalAssets;
    public PlatformAssets platformAssets;

    Assets(){}

    public void init(AssetManager assetManager)
    {
        this.assetManager =assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        stickmanAssets=new StickmanAssets(atlas);
        shootAssets=new ShootAssets(atlas);
        enemyAssets=new EnemyAssets(atlas);
        goalAssets=new GoalAssets(atlas);
        platformAssets=new PlatformAssets(atlas);
    }
    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class StickmanAssets
    {
        public final AtlasRegion standing;
        public final AtlasRegion aiming;
        public final AtlasRegion jumping;

        public final Animation leftAnimation;
        public final Animation rightAnimation;

        public StickmanAssets(TextureAtlas atlas) {
            aiming=atlas.findRegion(Constants.AIMING);
            standing=atlas.findRegion(Constants.STANDING);
            jumping=atlas.findRegion(Constants.JUMPING);

            // TODO: Create an Array of AtlasRegions to hold the walking left frames
            Array<AtlasRegion> walkingLeftFrames = new Array<AtlasRegion>();

            // TODO: Add the proper frames to the array
            walkingLeftFrames.add(atlas.findRegion(Constants.RUNNING1_LEFT));
            walkingLeftFrames.add(atlas.findRegion(Constants.RUNNING2_LEFT));
            walkingLeftFrames.add(atlas.findRegion(Constants.RUNNING3_LEFT));
            walkingLeftFrames.add(atlas.findRegion(Constants.RUNNING4_LEFT));

            // TODO: Create the walking left animation
            leftAnimation = new Animation(Constants.LOOP_DURATION, walkingLeftFrames, Animation.PlayMode.LOOP);

            // TODO: Do the same with the walking right frames
            Array<AtlasRegion> walkingRightFrames = new Array<AtlasRegion>();
            walkingRightFrames.add(atlas.findRegion(Constants.RUNNING1_RIGHT));
            walkingRightFrames.add(atlas.findRegion(Constants.RUNNING2_RIGHT));
            walkingRightFrames.add(atlas.findRegion(Constants.RUNNING3_RIGHT));
            walkingRightFrames.add(atlas.findRegion(Constants.RUNNING4_RIGHT));

            rightAnimation = new Animation(Constants.LOOP_DURATION, walkingRightFrames, Animation.PlayMode.LOOP);

        }
    }


    public class ShootAssets {

        public final AtlasRegion shoot;

        public ShootAssets(TextureAtlas atlas) {
            shoot = atlas.findRegion(Constants.SHOOT);
        }
    }

    public class EnemyAssets {

        public final AtlasRegion enemy;

        public EnemyAssets(TextureAtlas atlas) {
            enemy = atlas.findRegion(Constants.ENEMY);
        }
    }

    public class GoalAssets
    {
        public final AtlasRegion goal;
        public GoalAssets(TextureAtlas atlas){goal=atlas.findRegion(Constants.GOAL);}
    }

    public class PlatformAssets
    {
        public final NinePatch platform;

        public PlatformAssets(TextureAtlas atlas) {
            AtlasRegion region = atlas.findRegion(Constants.PLATFORM);
            int edge = 8;
            platform = new NinePatch(region, edge, edge, edge, edge);
        }
    }
}
