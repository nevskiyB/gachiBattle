package com.mygdx.gachibattle.updater.physics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.gachibattle.updater.render.Render;
import com.mygdx.gachibattle.updater.Updater;

public class DebugRenderPhysics implements Updater {
    private final Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private final Matrix4 combinedCamera = Render.INSTANCE.camera.combined;
    private final World world = Physics.INSTANCE.WORLD;
    public final static DebugRenderPhysics INSTANCE = new DebugRenderPhysics();

    private DebugRenderPhysics() {}
    @Override
    public void update() {
        debugRenderer.render(world, combinedCamera);
    }
}
