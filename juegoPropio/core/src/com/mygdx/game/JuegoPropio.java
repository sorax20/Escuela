package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;

public class JuegoPropio extends Game {
	
	@Override
	public void create ()
	{
        setScreen(new GameScreen());
	}
}
