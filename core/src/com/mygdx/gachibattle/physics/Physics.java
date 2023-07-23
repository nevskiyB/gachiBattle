package com.mygdx.gachibattle.physics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Physics {
    public final World WORLD = new World(new Vector2(0, -10), true);
    public static final Physics INSTANCE = new Physics();
    private final Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private final float TIME_STEP = 1/60f;
    private final int VELOCITY_ITERATIONS = 6;
    private final int POSITION_ITERATIONS = 2;

    private Physics() {}

    public void simpleStep() {
        WORLD.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    public void simpleStepWithDebug(Matrix4 combinedCamera) {
        debugRenderer.render(WORLD, combinedCamera);
        simpleStep();
    }
}
