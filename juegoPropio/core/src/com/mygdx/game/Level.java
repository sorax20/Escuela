package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.entidades.Enemy;
import com.mygdx.game.entidades.Shoot;
import com.mygdx.game.entidades.Stickman;
import com.mygdx.game.util.Constants;


/**
 * Created by jrs on 19/01/18.
 */

public class Level
{
    ScreenViewport hudViewport;
    //Array<Enemy> enemies;
    //Enemy enemy;
    long initTime;
    long diferenciaSpawn;
    private DelayedRemovalArray<Enemy> enemies;
    Stickman stickman;
    Shoot shoot;
    boolean apearEnemy;
    int enemigosPantalla=5;
    int enemiesDefeated;
    int enemiesToDefeat;
    Viewport viewport;
    BitmapFont font;
    boolean victoria;
    GameScreen padre;

    public Level(Viewport viewport,ScreenViewport hudViewport,GameScreen padre)
    {
        this.padre=padre;
        this.hudViewport = hudViewport;
        this.viewport=viewport;
        enemiesToDefeat=10;
        reset();
        //enemies;
        //stickman= new Stickman(new Vector2(500,0),this);
        //enemy=new Enemy(this);
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(3,5);
    }

    public void update(float delta) {
        if(victoria)return;
        stickman.update(delta,null);
        long actualTime=System.currentTimeMillis()-initTime;
        if(actualTime-diferenciaSpawn>0)
        {
            diferenciaSpawn+=1000;
            enemies.add(new Enemy(this));
            apearEnemy=false;
        }
        if(shoot!=null)shoot.update(delta);
        for(Enemy enemy:enemies)
        {
            enemy.update(delta);
            if(shoot!=null)
            {
                //shoot.update(delta);
                if (enemy.getPosition().dst(shoot.getPosition()) < 50)
                {
                    shoot = null;
                    //enemy = new Enemy(this);
                    enemies.removeValue(enemy,false);
                    enemiesDefeated++;
                }
            }
        }
        if(enemiesToDefeat-enemiesDefeated<=0)victoria=true;
        //if(enemy!=null)enemy.update(delta);
        /*for (Enemy enemy : enemies) {
            enemy.update(delta);
        }*/
    }

    public void reset()
    {
        initTime=System.currentTimeMillis();
        diferenciaSpawn=0;
        stickman=new Stickman(new Vector2(500,0),this,viewport,true);
        shoot=null;
        apearEnemy=true;
        enemiesDefeated=0;
        //enemy=new Enemy(this);
        enemies=new DelayedRemovalArray<Enemy>(false,5);
        victoria=false;
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        stickman.render(batch);
        if(shoot!=null)shoot.render(batch);
        //if(enemy!=null)enemy.render(batch);
        enemies.begin();
        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }
        enemies.end();

     /*   for (Enemy enemy : enemies) {
            enemy.render(batch);
        }*/

        font.draw(batch,"Enemies left:"+(enemiesToDefeat-enemiesDefeated),20,Constants.SIZE_MAP2-20);
        if(victoria)victoria(batch);
        batch.end();
    }

    public void disparo(Vector2 positionDisparo)
    {
        if(shoot==null||shoot.getAltura()>Constants.SIZE_MAP2)shoot=new Shoot(positionDisparo, Constants.SIZE_MAP2);
    }

    void victoria(SpriteBatch batch)
    {
        font.draw(batch,"YOU WIN",Constants.SIZE_MAP2/2,Constants.SIZE_MAP2/2);
    }
}
