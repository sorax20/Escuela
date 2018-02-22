package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entidades.Shoot;
import com.mygdx.game.util.Assets;
import com.mygdx.game.util.ChaseCam;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.Hud;

/**
 * Created by jrs on 19/01/18.
 */

public class GameScreen extends ScreenAdapter
{
    SpriteBatch batch;
    ExtendViewport viewport;
    ScreenViewport hudViewport;
    Level level;
    LevelRunning levelRunning;
    Shoot shoot;
    Victory victory;
    boolean levelShooting;
    private ChaseCam chaseCam;
    Hud hud;

    @Override
    public void show()
    {
        levelShooting=false;
        AssetManager am = new AssetManager();
        Assets.instance.init(am);
        batch=new SpriteBatch();
        viewport=new ExtendViewport(Constants.SIZE_MAP2,Constants.SIZE_MAP2);
        hudViewport=new ScreenViewport();
        hud=new Hud();
        if(levelShooting)iniciarShooting();
        else iniciarRunning();
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        hudViewport.update(width, height, true);
        hud.viewport.update(width,height,true);
    }
    @Override
    public void dispose()
    {
        Assets.instance.dispose();
        batch.dispose();
    }

    @Override
    public void render(float delta)
    {

        if(levelShooting)
        {
            level.update(delta);
            if(chaseCam==null)new ChaseCam(viewport.getCamera(),level.stickman).reset();
        }
        else{
            levelRunning.update(delta);
            //chaseCam.update();
        }
        viewport.apply();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        if(levelShooting)level.render(batch);
        else levelRunning.render(batch);
    }

    public void iniciarRunning()
    {
        levelRunning=new LevelRunning(viewport,this,hud);
        //chaseCam=new ChaseCam(viewport.getCamera(),levelRunning.stickman);
        levelShooting=false;
    }
    public void iniciarShooting()
    {
        //viewport=new ExtendViewport(Constants.SIZE_MAP2,Constants.SIZE_MAP2);
        //hudViewport=new ScreenViewport();
        //viewport.update(700,500,true);
        levelShooting=true;
        level = new Level(viewport,hudViewport,this);
    }
}
