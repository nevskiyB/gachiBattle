package com.mygdx.gachibattle;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gachibattle.entity.utils.state.InputProcessorStateMachine;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.updater.render.Render;
import com.mygdx.gachibattle.entity.Ground;
import com.mygdx.gachibattle.updater.physics.DebugRenderPhysics;
import com.mygdx.gachibattle.updater.physics.Physics;
import com.mygdx.gachibattle.entity.Player;

public class GachiBattle extends ApplicationAdapter {
	private InputProcessorStateMachine actionsAccessor;
	private Render render;
	private Physics physics;
	private DebugRenderPhysics debugRenderPhysics;
	private Player playerObject;
	private Ground groundObject;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("Init", "Initialization started");

		actionsAccessor = new InputProcessorStateMachine(new DefaultControlSetup());
		Gdx.input.setInputProcessor(actionsAccessor);
		render = Render.INSTANCE;
		physics = Physics.INSTANCE;
		debugRenderPhysics = DebugRenderPhysics.INSTANCE;

		Gdx.app.log("Init character", "Character creating started");
		playerObject = new Player(new Vector2(50, 100), actionsAccessor);
		Gdx.app.log("Init character", "Character creating ended");

		Gdx.app.log("Init ground", "Ground creating started");
		groundObject = new Ground( new Vector2(-50, -300));
		Gdx.app.log("Init ground", "Ground creating ended");

		Gdx.app.log("Init", "Initialization end");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		render.batch.begin();

		playerObject.performActionStates();
		groundObject.performActionStates();

		render.batch.end();

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
