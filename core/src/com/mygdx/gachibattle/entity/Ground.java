package com.mygdx.gachibattle.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.ActionState;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.actions.view.DrawAction;
import com.mygdx.gachibattle.entity.utils.components.physics.BodyComponent;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;
import com.mygdx.gachibattle.entity.utils.state.AnyStateMachine;
import com.mygdx.gachibattle.updater.physics.Physics;


public class Ground extends AbstractEntity implements Disposable {
    public Ground(Vector2 initPosition) {
        super(new AnyStateMachine());
        //Components
        TextureRegion textureRegion = new TextureRegion(new Texture("badlogic.jpg"));
        components.add(new ViewComponent(textureRegion));
        components.add(new BodyComponent(getBody(initPosition,
                new Vector2(textureRegion.getTexture().getWidth(), textureRegion.getTexture().getHeight()),
                BodyDef.BodyType.StaticBody,
                100f)));

        //Actions
        try {
            actions.add(new ActionState(new DrawAction(this)));
        }
        catch (ComponentMissingException e) {
            Gdx.app.error("Initialization error", e.getMessage());
            Gdx.app.exit();
        }
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
