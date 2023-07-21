package com.mygdx.gachibattle.updaters;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.controllers.MoveActionsAccessor;


public class MoveUpdater implements Updater {
    private final int speed;
    private Vector2 location;
    private final MoveActionsAccessor actionsAccessor;

    public MoveUpdater(MoveActionsAccessor actionsAccessor, Vector2 location, int speed) {
        this.actionsAccessor = actionsAccessor;
        this.location = location;
        this.speed = speed;
    }

    @Override
    public void update() {
        if(actionsAccessor.getGoLeft())
            location.x -= speed;
        if(actionsAccessor.getGoRight())
            location.x += speed;
    }
}
