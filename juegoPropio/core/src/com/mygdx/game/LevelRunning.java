package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.entidades.Goal;
import com.mygdx.game.entidades.Platform;
import com.mygdx.game.entidades.Platforms;
import com.mygdx.game.entidades.Stickman;
import com.mygdx.game.util.ChaseCam;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.Hud;

/**
 * Created by jrs on 15/02/18.
 */

public class LevelRunning
{
    GameScreen padre;
    ChaseCam cam;
    long initTime,finalTime;
    ScreenViewport hudViewport;
    Stickman stickman;
    Viewport viewport;
    BitmapFont font;
    Goal goal;
    Platforms platforms;
    Hud hud;

    LevelRunning(Viewport viewport,GameScreen padre,Hud hud)
    {
        this.hud=hud;
        this.padre=padre;
        this.viewport=viewport;
        //this.hudViewport=hudViewport;
        finalTime=21000;
        reset();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(3,5);
    }

    public void render(SpriteBatch batch)
    {
        batch.begin();
        stickman.render(batch);
        goal.render(batch);
        platforms.render(batch);
        long actualTime=System.currentTimeMillis()-initTime;
        long tiempoRestante=(finalTime-actualTime)/1000;
        hud.render(batch,tiempoRestante);
        if(tiempoRestante<=0)reset();
        if(stickman.position.y<-400)reset();
        batch.end();
    }
    public void update(float delta)
    {
        stickman.update(delta,platforms.getPlataforms());
        cam.update();
        if(goal.getPosition().dst(stickman.getPosition())<100)padre.iniciarShooting();
    }

    void reset()
    {
        stickman=new Stickman(new Vector2(0,10),this,viewport,false);
        this.cam=new ChaseCam(viewport.getCamera(),stickman);
        platforms=new Platforms();
        initTime=System.currentTimeMillis();
        goal=new Goal(new Vector2(4400,0));
    }

}
