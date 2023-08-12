package com.mygdx.gachibattle.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.ComponentsHolder;
import com.mygdx.gachibattle.entity.utils.actions.ActionState;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkRightAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkRightAction;
import com.mygdx.gachibattle.entity.utils.actions.view.DrawAction;
import com.mygdx.gachibattle.entity.utils.components.physics.BodyComponent;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;
import com.mygdx.gachibattle.entity.utils.state.AnyStateMachine;
import com.mygdx.gachibattle.entity.utils.state.InputProcessorStateMachine;
import com.mygdx.gachibattle.entity.utils.state.State;
import com.mygdx.gachibattle.entity.utils.state.StateMachine;
import com.mygdx.gachibattle.updater.Updater;
import com.mygdx.gachibattle.updater.physics.Physics;

import java.util.Collections;


public class Ground extends AbstractEntity implements Disposable {
    public Ground(Vector2 initPosition) {
        super(new AnyStateMachine());
        //Components
        Texture texture = new Texture("badlogic.jpg");
        components.add(new ViewComponent(texture));
        components.add(new BodyComponent(getBody(initPosition,
                new Vector2(texture.getWidth(), texture.getHeight()),
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
