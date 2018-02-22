package com.mygdx.game.util;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.entidades.Stickman;

/**
 * Created by jrs on 21/02/18.
 */

public class ChaseCam {

    public Camera camera;
    ExtendViewport viewport;

    private Stickman target;


    public ChaseCam(Camera camera, Stickman target) {
        this.viewport = new ExtendViewport(480, 480);
        this.camera = camera;
        this.target = target;
    }


    public void update() {
        camera.position.x = target.position.x+50;
        camera.position.y = target.position.y+50;
    }
    public void reset(){
        camera.position.x=Constants.SIZE_MAP2/2+150;
        camera.position.y=Constants.SIZE_MAP2/2;
    }
}