package com.mygdx.gachibattle.updaters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gachibattle.gameobject.GameObject;

public class RenderUpdater implements Updater {
    private final SpriteBatch batch;
    private final GameObject obj;

    public RenderUpdater(SpriteBatch batch, GameObject obj) {
        this.batch = batch;
        this.obj = obj;
    }

    @Override
    public void update() {
        batch.draw(obj.getImg(), obj.getLocation().x, obj.getLocation().y);
    }
}
