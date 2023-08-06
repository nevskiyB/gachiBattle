package com.mygdx.gachibattle.updater.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.components.position.physics.BodyComponent;
import com.mygdx.gachibattle.components.visual.VisualComponent;
import com.mygdx.gachibattle.updater.Updater;
import com.mygdx.gachibattle.updater.physics.Physics;

import java.util.Collections;


public class Ground implements Updater, Disposable {
    protected final String id;
    private final BodyComponent bodyElement;
    private final VisualComponent visualElement;

    public Ground(String id, Vector2 initPosition) {
        this.id = id;

        Texture texture = new Texture("badlogic.jpg");

        bodyElement = new BodyComponent(
                getBody(initPosition,
                        new Vector2(texture.getWidth(), texture.getHeight()),
                        BodyDef.BodyType.StaticBody,
                        100f),
                Collections.EMPTY_LIST);

        visualElement = new VisualComponent(texture, Collections.EMPTY_LIST, bodyElement);
    }

    @Override
    public void update() {
    }

    public void dispose () {}

    private Body getBody(Vector2 initPosition, Vector2 size, BodyDef.BodyType bodyType, float mass) {
        float halfFixtureWidth = size.x/2f;
        float halfFixtureHeight = size.y/2f;

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(halfFixtureWidth, halfFixtureHeight, new Vector2(halfFixtureWidth, halfFixtureHeight), 0f);

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(initPosition);

        Body body = Physics.INSTANCE.WORLD.createBody(bodyDef);
        MassData massData = new MassData();
        massData.mass = mass;
        body.setFixedRotation(true);
        body.setMassData(massData);
        body.resetMassData();
        body.setType(bodyType);

        Fixture mainFixture = body.createFixture(poly, 100f);
        mainFixture.setFriction(1f);

        poly.dispose();

        return body;
    }
}
