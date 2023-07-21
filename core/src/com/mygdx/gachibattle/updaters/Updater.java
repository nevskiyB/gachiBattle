package com.mygdx.gachibattle.updaters;

/**
 * Each game object have updater list.
 * Updater do some work every game-loop iteration
 */
public interface Updater {
    /**
     * An action that is executed every iteration of game-loop
     */
    void update();
}
