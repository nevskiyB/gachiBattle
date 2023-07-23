package com.mygdx.gachibattle.updaters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gachibattle.gameobject.GameObject;

public class RenderUpdater extends Updater {
    private final SpriteBatch batch;

    public RenderUpdater(GameObject gameObject, SpriteBatch batch) {
        super(gameObject);
        this.batch = batch;
        Gdx.app.log("Init | id:" + gameObject.getId(), "RenderUpdater created!");
    }

    @Override
    public void update() {
        batch.draw(gameObject.getImg(), gameObject.getLocation().x, gameObject.getLocation().y);
    }
}
