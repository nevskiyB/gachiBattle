package com.mygdx.gachibattle;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.updater.Render;
import com.mygdx.gachibattle.updater.gameobjects.Ground;
import com.mygdx.gachibattle.updater.physics.DebugRenderPhysics;
import com.mygdx.gachibattle.updater.physics.Physics;
import com.mygdx.gachibattle.updater.gameobjects.Player;

public class GachiBattle extends ApplicationAdapter {
	private DefaultInputProcessor actionsAccessor;
	private Render render;
	private Physics physics;
	private DebugRenderPhysics debugRenderPhysics;
	private Player playerObject;
	private Ground groundObject;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("Init", "Initialization started");

		actionsAccessor = new DefaultInputProcessor(new DefaultControlSetup());
		Gdx.input.setInputProcessor(actionsAccessor);
		render = Render.INSTANCE;
		physics = Physics.INSTANCE;
		debugRenderPhysics = DebugRenderPhysics.INSTANCE;

		Gdx.app.log("Init character", "Character creating started");
		playerObject = new Player("player", new Vector2(50, 100), actionsAccessor);
		Gdx.app.log("Init character", "Character creating ended");

		Gdx.app.log("Init ground", "Ground creating started");
		groundObject = new Ground("ground", new Vector2(-50, -300));
		Gdx.app.log("Init ground", "Ground creating ended");

		Gdx.app.log("Init", "Initialization end");
	}

	@Override
	public void render () {
		playerObject.update();

		render.update();
		debugRenderPhysics.update();
		physics.update();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		for (GameObject obj : generalObjectList) {
//			obj.dispose();
//		}
	}
}
