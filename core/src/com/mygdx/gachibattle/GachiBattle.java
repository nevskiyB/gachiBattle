package com.mygdx.gachibattle;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.gameobject.physical.DefaultPhysicalObject;
import com.mygdx.gachibattle.gameobject.physical.PhysicalGameObject;
import com.mygdx.gachibattle.physics.Physics;
import com.mygdx.gachibattle.updaters.PhysicsUpdater;
import com.mygdx.gachibattle.updaters.RenderUpdater;
import com.mygdx.gachibattle.gameobject.GameObject;
import com.mygdx.gachibattle.updaters.movement.BodyMoveUpdater;

import java.util.ArrayList;
import java.util.Collection;

public class GachiBattle extends ApplicationAdapter {
	private SpriteBatch batch;
	private DefaultInputProcessor actionsAccessor;
	private Collection<GameObject> generalObjectList;
	private OrthographicCamera camera;
	private Physics physics;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("Init", "Initialization started");
		batch = new SpriteBatch();
		actionsAccessor = new DefaultInputProcessor(new DefaultControlSetup());
		generalObjectList = new ArrayList<>();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		physics = Physics.INSTANCE;
		Gdx.input.setInputProcessor(actionsAccessor);
		batch.setProjectionMatrix(camera.combined);

		createObjects();

		Gdx.app.log("Init", "Initialization end");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		for (GameObject obj : generalObjectList) {
			obj.doUpdate();
		}
		batch.end();
		physics.simpleStepWithDebug(camera.combined);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (GameObject obj : generalObjectList) {
			obj.dispose();
		}
	}

	private void createObjects() {
		Gdx.app.log("Init character", "Character creating started");
		PhysicalGameObject character = new DefaultPhysicalObject(
				"mainCharacter",
				new Texture("billy.png"),
				new Vector2(0, 0),
				100f,
				BodyDef.BodyType.DynamicBody);
		character.addUpdater(new RenderUpdater(character, batch));
		character.addUpdater(new BodyMoveUpdater(character, actionsAccessor, 10));
		character.addUpdater(new PhysicsUpdater(character));
		generalObjectList.add(character);
		Gdx.app.log("Init character", "Character creating end");

		Gdx.app.log("Init ground", "Ground creating started");
		PhysicalGameObject ground = new DefaultPhysicalObject(
				"ground",
				new Texture("badlogic.jpg"),
				new Vector2(0, -300),
				0f,
				BodyDef.BodyType.StaticBody);
		ground.addUpdater(new RenderUpdater(ground, batch));
		generalObjectList.add(ground);
		Gdx.app.log("Init ground", "Ground creating end");
	}
}
