package com.mygdx.gachibattle.updaters.movement;

import com.badlogic.gdx.Gdx;
import com.mygdx.gachibattle.controllers.MoveActionsAccessor;
import com.mygdx.gachibattle.gameobject.GameObject;
import com.mygdx.gachibattle.updaters.Updater;


public class TextureMoveUpdater extends Updater {
    private final int speed;
    private final MoveActionsAccessor actionsAccessor;

    public TextureMoveUpdater(GameObject gameObject, MoveActionsAccessor actionsAccessor, int speed) {
        super(gameObject);
        this.actionsAccessor = actionsAccessor;
        this.speed = speed;
        Gdx.app.log("Init | id:" + gameObject.getId(), "PhysicalMoveUpdater created!");
    }

    @Override
    public void update() {
        if(actionsAccessor.getGoLeft())
            gameObject.getLocation().x -= speed;
        if(actionsAccessor.getGoRight())
            gameObject.getLocation().x += speed;
    }
}
