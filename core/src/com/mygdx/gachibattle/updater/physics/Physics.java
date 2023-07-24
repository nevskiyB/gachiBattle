package com.mygdx.gachibattle.updater.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.gachibattle.updater.Updater;

public class Physics implements Updater {
    public final World WORLD = new World(new Vector2(0, -10), true);
    public static final Physics INSTANCE = new Physics();
    private final float TIME_STEP = 1/60f;
    private final int VELOCITY_ITERATIONS = 6;
    private final int POSITION_ITERATIONS = 2;

    private Physics() {}

    @Override
    public void update() {
        WORLD.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }
}
