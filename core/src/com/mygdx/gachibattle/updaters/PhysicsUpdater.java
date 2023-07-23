package com.mygdx.gachibattle.updaters;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.gameobject.physical.PhysicalGameObject;

public class PhysicsUpdater extends Updater {
    private final Body body;

    public PhysicsUpdater(PhysicalGameObject gameObject) {
        super(gameObject);
        body = gameObject.getBody();
    }

    @Override
    public void update() {
        //Sync of image and physics body positions
        gameObject.getLocation().set(body.getPosition());
    }
}
