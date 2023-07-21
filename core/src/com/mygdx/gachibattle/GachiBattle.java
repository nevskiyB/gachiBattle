package com.mygdx.gachibattle;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.updaters.MoveUpdater;
import com.mygdx.gachibattle.updaters.RenderUpdater;
import com.mygdx.gachibattle.gameobject.GameObject;
import com.mygdx.gachibattle.gameobject.DefaultGameObject;

import java.util.ArrayList;
import java.util.Collection;

public class GachiBattle extends ApplicationAdapter {
	private SpriteBatch batch;
	private DefaultInputProcessor actionsAccessor;
	private Collection<GameObject> generalObjectList;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("Init", "Initialization started");
		batch = new SpriteBatch();
		actionsAccessor = new DefaultInputProcessor(new DefaultControlSetup());
		generalObjectList = new ArrayList<>();
		Gdx.input.setInputProcessor(actionsAccessor);

		GameObject character = new DefaultGameObject(
				new Texture("badlogic.jpg"),
				new Vector2(100, 100));
		character.addUpdater(new MoveUpdater(actionsAccessor, character.getLocation(), 10));
		character.addUpdater(new RenderUpdater(batch, character));
		generalObjectList.add(character);

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
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (GameObject obj : generalObjectList) {
			obj.dispose();
		}
	}
}
