package com.mygdx.gachibattle.updaters;

import com.mygdx.gachibattle.gameobject.GameObject;

/**
 * Each game object have updater list.
 * Updater do some work every game-loop iteration
 */
public abstract class Updater {
    protected GameObject gameObject;

    public Updater(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    /**
     * An action that is executed every iteration of game-loop
     */
    public abstract void update();
}
