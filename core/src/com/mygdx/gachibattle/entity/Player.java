package com.mygdx.gachibattle.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.controllers.controlsetup.ControlSetup;
import com.mygdx.gachibattle.controllers.controlsetup.DefaultControlSetup;
import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.ActionState;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.actions.view.DrawAction;
import com.mygdx.gachibattle.entity.utils.state.InputProcessorStateMachine;
import com.mygdx.gachibattle.entity.utils.components.physics.BodyComponent;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkRightAction;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkRightAction;
import com.mygdx.gachibattle.entity.utils.state.State;
import com.mygdx.gachibattle.entity.utils.state.StateMachine;
import com.mygdx.gachibattle.updater.physics.Physics;



public class Player extends AbstractEntity implements Disposable {
    public Player(Vector2 initPosition, StateMachine stateMachine) {
        super(stateMachine);

        //Components
        Texture texture = new Texture("idel/billy.png");
        components.add(new ViewComponent(texture));
        components.add(new BodyComponent(getBody(initPosition,
                new Vector2(texture.getWidth(), texture.getHeight()),
                BodyDef.BodyType.DynamicBody,
                100f)));

        //Actions
        try {
            actions.add(new ActionState(new DrawAction(this)));
            actions.add(new ActionState(State.walkRight,
                new PhysicalMovementWalkRightAction(this, 20f),
                new AnimationWalkRightAction(this, 0.3f, getWalkRightFrames())));
            actions.add(new ActionState(State.walkLeft,
                new PhysicalMovementWalkLeftAction(this, 20f),
                new AnimationWalkLeftAction(this, 0.3f, getWalkLeftFrames())));
            actions.add(new ActionState(State.idle,
                new AnimationWalkLeftAction(this, 0f, getIdleFrames())));
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

    private Array<Texture> getIdleFrames() {
        Array<Texture> keyFramesIdel = new Array<>();
		keyFramesIdel.add(new Texture("idel/billy.png"));
        return keyFramesIdel;
    }

    private Array<Texture> getWalkRightFrames() {
        Array<Texture> keyFramesRightWalk = new Array<>();

        keyFramesRightWalk.add(new Texture("walkRight/0000.png"));
        keyFramesRightWalk.add(new Texture("walkRight/0001.png"));
        keyFramesRightWalk.add(new Texture("walkRight/0002.png"));
        keyFramesRightWalk.add(new Texture("walkRight/0003.png"));

        return keyFramesRightWalk;
    }

    private Array<Texture> getWalkLeftFrames() {
		Array<Texture> keyFramesLeftWalk = new Array<>();

		keyFramesLeftWalk.add(new Texture("walkLeft/0000.png"));
		keyFramesLeftWalk.add(new Texture("walkLeft/0001.png"));
		keyFramesLeftWalk.add(new Texture("walkLeft/0002.png"));
		keyFramesLeftWalk.add(new Texture("walkLeft/0003.png"));

        return keyFramesLeftWalk;
    }
}
