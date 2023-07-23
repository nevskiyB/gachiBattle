package com.mygdx.gachibattle.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.updaters.Updater;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultGameObject implements GameObject {
    private final String id;
    private final Collection<Updater> updaters;
    private final Texture img;
    private final Vector2 location;

    public DefaultGameObject(String id, Texture img, Vector2 location) {
        this.id = id;
        this.updaters = new ArrayList<>();
        this.img = img;
        this.location = location;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Texture getImg() {
        return img;
    }
    @Override
    public Vector2 getLocation() {
        return location;
    }
    @Override
    public void doUpdate() {
        for (Updater updater : updaters) {
            updater.update();
        }
    }
    @Override
    public void addUpdater(Updater updater) {
        updaters.add(updater);
    }
    @Override
    public void dispose() {
        img.dispose();
    }
}
