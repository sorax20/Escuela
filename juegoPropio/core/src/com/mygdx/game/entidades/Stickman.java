package com.mygdx.game.entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Level;
import com.mygdx.game.LevelRunning;
import com.mygdx.game.util.Assets;
import com.mygdx.game.util.Constants;

import java.util.ArrayList;

/**
 * Created by jrs on 19/01/18.
 */

public class Stickman
{
    public boolean jumpButtonPressed;
    public boolean leftButtonPressed;
    public boolean rightButtonPressed;
    public boolean jumpLevel;
    boolean toRight,toLeft,running;
    boolean grounded;
    boolean falling;
    private Vector2 spawnLocation;
    public Vector2 position;
    private Vector2 lastFramePosition;
    private Vector2 velocity;
    Level juego;
    LevelRunning juego1;
    Viewport viewport;
    boolean disparos;
    final long tiempoSalto=350;
    long tiempoInicioSalto;

    long walkStartTime;

    public Stickman(Vector2 spawnLocation, Level juego, Viewport viewport,boolean disparos)
    {
        running=false;
        toRight=false;
        toLeft=false;
        this.disparos=disparos;
        this.viewport=viewport;
        this.juego=juego;
        this.spawnLocation=spawnLocation;
        position=spawnLocation;
    }

    public Stickman(Vector2 spawnLocation, LevelRunning juego, Viewport viewport, boolean disparos)
    {
        this.disparos=disparos;
        this.viewport=viewport;
        this.juego1=juego;
        this.spawnLocation=spawnLocation;
        lastFramePosition=new Vector2(0,0);
        velocity=new Vector2(0,0);
        velocity.setZero();
        position=spawnLocation;
        tiempoInicioSalto=0;
        grounded=true;
    }
    public void update(float delta,ArrayList <Platform>plataformas)
    {
        if(disparos)moveShooting(delta);
        else moveJumping(delta,plataformas);
    }

    void moveJumping(float delta,ArrayList <Platform>plataformas)
    {
        lastFramePosition.set(position);
        velocity.y=Constants.FALL_SPEED;
        //position.mulAdd(velocity, delta);
        grounded=false;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            toLeft=true;
            toRight=false;
            running=true;
            moveLeft(delta);
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            toRight=true;
            toLeft=false;
            running=true;
            moveRight(delta);
        }else{
            toRight=false;
            toLeft=false;
            running=false;
        }

        if(!running)walkStartTime=TimeUtils.nanoTime();

        if(Gdx.input.isKeyPressed(Input.Keys.X)&&!falling)
        {
            if(tiempoInicioSalto==0)tiempoInicioSalto=System.currentTimeMillis();
            falling=false;
            jump(delta);
            if(System.currentTimeMillis()-tiempoInicioSalto>tiempoSalto)
            {
                falling=true;
                tiempoInicioSalto=0;
            }
        }else falling=true;

        for(Platform platform:plataformas)
        {
            if(landedOnPlatform(platform))
            {
                grounded=true;
            }
        }
        if(falling&&!grounded)
        {
            position.y-=delta*Constants.FALL_SPEED;
        }else falling=false;
    }

    void moveShooting(float delta)
    {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)&&position.x>0) {
            moveLeft(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&position.x<Constants.SIZE_MAP2) {
            moveRight(delta);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {

            Vector2 bulletPosition;
            bulletPosition=new Vector2(position.x+48,position.y+300);
            juego.disparo(bulletPosition);
        }
    }

    private void moveLeft(float delta) {
        position.x -= delta * Constants.MOVEMENT_SPEED;
    }
    private void moveRight(float delta) {
        position.x += delta * Constants.MOVEMENT_SPEED;
    }
    private void jump(float delta){position.y+=delta*Constants.JUMP_SPEED;}

    public void render(SpriteBatch batch)
    {
        TextureRegion region;
        if(disparos)region=Assets.instance.stickmanAssets.aiming;
        else{
            if(grounded)
            {
                if (toRight)
                {
                    float tiempoCorriendo = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime);
                    region = Assets.instance.stickmanAssets.rightAnimation.getKeyFrame(tiempoCorriendo);
                }else if(toLeft){
                    float tiempoCorriendo = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime);
                    region = Assets.instance.stickmanAssets.leftAnimation.getKeyFrame(tiempoCorriendo);
                }else region=Assets.instance.stickmanAssets.standing;
            }else{
                region=Assets.instance.stickmanAssets.jumping;
            }
        }

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

    boolean landedOnPlatform(Platform platform) {
        boolean leftFootIn = false;
        boolean rightFootIn = false;
        boolean straddle = false;

        if (lastFramePosition.y +7  >= platform.top &&
                position.y -7 < platform.top) {

            float leftFoot = position.x ;
            float rightFoot = position.x + Constants.STICKMAN_SIZE_X;

            leftFootIn = (platform.left < leftFoot && platform.right > leftFoot);
            rightFootIn = (platform.left < rightFoot && platform.right > rightFoot);
            straddle = (platform.left > leftFoot && platform.right < rightFoot);
        }
        return leftFootIn || rightFootIn || straddle;
    }
}
