package com.mygdx.game.util;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by jrs on 19/01/18.
 */

public class Constants
{
    //datos de velocidades
    public static final float JUMP_SPEED = 700;
    public static final float MOVEMENT_SPEED=650;
    public static final float SHOOT_SPEED=600;
    public static final float ENEMY_SPEED=400;
    public static final float FALL_SPEED=800;

    //Imagenes a usar
    public static final String TEXTURE_ATLAS="imagenes/imagenesJuego.pack";
    public static final String ENEMY="enemy";
    public static final String STANDING="standing";
    public static final String JUMPING="jumping";
    public static final String RUNNING1_RIGHT="runRight1";
    public static final String RUNNING2_RIGHT="runRight2";
    public static final String RUNNING3_RIGHT="runRight3";
    public static final String RUNNING4_RIGHT="runRight4";
    public static final String RUNNING1_LEFT="runLeft1";
    public static final String RUNNING2_LEFT="runLeft2";
    public static final String RUNNING3_LEFT="runLeft3";
    public static final String RUNNING4_LEFT="runLeft4";
    public static final String AIMING="aiming";
    public static final String SHOOT="shoot";
    public static final String GOAL="goal";
    public static final String PLATFORM="platform";

    public static final float LOOP_DURATION = 0.1f;

    //public static final Vector2 EYE_POSITION = new Vector2(16, 24);
    public static final float SIZE_MAP2=1080;

    public static final float STICKMAN_SIZE_X=105;
    public static final float STICKMAN_SIZE_Y=319;
}
