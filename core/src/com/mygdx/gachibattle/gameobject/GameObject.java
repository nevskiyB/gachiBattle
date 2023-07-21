package com.mygdx.gachibattle.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.updaters.Updater;

/**
 * The game entity with: view, location and actions(updaters)
 */
public interface GameObject extends Disposable {
    Texture getImg();
    Vector2 getLocation();
    void addUpdater(Updater updater);
    void doUpdate();
}
