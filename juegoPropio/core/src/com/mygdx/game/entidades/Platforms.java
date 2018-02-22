package com.mygdx.game.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jrs on 15/02/18.
 */

public class Platforms
{
    ArrayList<Platform> plataformas;
    public Platforms()
    {
        plataformas=new ArrayList(15);
        plataformas.add(new Platform(-10,-10,100,5));
        plataformas.add(new Platform(200,250,75,200));
        plataformas.add(new Platform(400,300,140,50));
        plataformas.add(new Platform(800,450,75,90));
        plataformas.add(new Platform(200,700,475,20));
        plataformas.add(new Platform(900,800,100,10));
        plataformas.add(new Platform(1500,800,200,450));
        plataformas.add(new Platform(1700,350,250,30));
        plataformas.add(new Platform(2350,250,350,70));
        plataformas.add(new Platform(2800,400,400,100));
        plataformas.add(new Platform(3600,500,300,200));
    }

    public void render(SpriteBatch batch)
    {
        for(Platform platform:plataformas)platform.render(batch);
    }

    public ArrayList getPlataforms(){return plataformas;}
}
