package com.mygdx.gachibattle.gameobject.physical;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.gachibattle.gameobject.DefaultGameObject;
import com.mygdx.gachibattle.physics.Physics;

public class DefaultPhysicalObject extends DefaultGameObject implements PhysicalGameObject {
    public Body mainBody;
    public Fixture mainFixture;

    public DefaultPhysicalObject(String id, Texture img, Vector2 location, float mass, BodyDef.BodyType bodyType) {
        super(id, img, location);

        float halfFictureWidth = img.getWidth()/2f;
        float halfFictureHeight = img.getHeight()/2f;

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(halfFictureWidth, halfFictureHeight, new Vector2(halfFictureWidth, halfFictureHeight), 0f);

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(location);

        mainBody = Physics.INSTANCE.WORLD.createBody(bodyDef);
        MassData massData = new MassData();
        massData.mass = mass;
        mainBody.setFixedRotation(true);
        mainBody.setMassData(massData);
        mainBody.resetMassData();
        mainBody.setType(bodyType);

        mainFixture = mainBody.createFixture(poly, 100f);
        mainFixture.setFriction(1f);

        poly.dispose();
    }

    @Override
    public Body getBody() {
        return mainBody;
    }
}
