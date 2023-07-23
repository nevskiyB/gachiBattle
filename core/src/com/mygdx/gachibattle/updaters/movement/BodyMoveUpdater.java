package com.mygdx.gachibattle.updaters.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.controllers.MoveActionsAccessor;
import com.mygdx.gachibattle.gameobject.physical.PhysicalGameObject;
import com.mygdx.gachibattle.updaters.Updater;

public class BodyMoveUpdater extends Updater {
    protected final float hVelocity;
    protected final Body body;
    protected final MoveActionsAccessor actionsAccessor;

    public BodyMoveUpdater(PhysicalGameObject gameObject, MoveActionsAccessor actionsAccessor, float hVelocity) {
        super(gameObject);
        this.actionsAccessor = actionsAccessor;
        this.body = gameObject.getBody();
        this.hVelocity = hVelocity;
        Gdx.app.log("Init | id:" + gameObject.getId(), "PhysicalMoveUpdater created!");
    }

    public Vector2 getPhysicalBodyLocation() {
        return body.getPosition();
    }

    @Override
    public void update() {
        if(actionsAccessor.getGoLeft())
            body.setLinearVelocity(-hVelocity, body.getLinearVelocity().y);
        if(actionsAccessor.getGoRight())
            body.setLinearVelocity(hVelocity, body.getLinearVelocity().y);
    }
}
