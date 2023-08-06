package com.mygdx.gachibattle.updater.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.StateProcessor;
import com.mygdx.gachibattle.components.position.physics.BodyComponent;
import com.mygdx.gachibattle.components.position.physics.processors.PhysicalMovementWalkLeftStateProcessor;
import com.mygdx.gachibattle.components.position.physics.processors.PhysicalMovementWalkRightStateProcessor;
import com.mygdx.gachibattle.components.state.StateComponent;
import com.mygdx.gachibattle.components.state.processors.InputAnyStateProcessor;
import com.mygdx.gachibattle.components.visual.VisualComponent;
import com.mygdx.gachibattle.components.visual.processors.AnimationIdleStateProcessor;
import com.mygdx.gachibattle.components.visual.processors.AnimationWalkLeftStateProcessor;
import com.mygdx.gachibattle.components.visual.processors.AnimationWalkRightStateProcessor;
import com.mygdx.gachibattle.updater.physics.Physics;
import com.mygdx.gachibattle.updater.Updater;

import java.util.ArrayList;
import java.util.Collection;


public class Player implements Updater, Disposable {
    protected final String id;
    private final StateComponent stateElement;
    private final BodyComponent bodyElement;
    private final VisualComponent visualElement;

    public Player(String id, Vector2 initPosition, DefaultInputProcessor inputProcessor) {
        this.id = id;

        Collection<StateProcessor> stateProcessorCollection = new ArrayList<>();
        stateElement = new StateComponent(State.idle, stateProcessorCollection);
        stateProcessorCollection.add(new InputAnyStateProcessor(stateElement, inputProcessor));

        Texture texture = new Texture("idel/billy.png");

        Collection<StateProcessor> bodyElementCollection = new ArrayList<>();
        bodyElement = new BodyComponent(
                getBody(initPosition,
                        new Vector2(texture.getWidth(), texture.getHeight()),
                        BodyDef.BodyType.DynamicBody,
                        100f),
                bodyElementCollection);
        bodyElementCollection.add(new PhysicalMovementWalkLeftStateProcessor(bodyElement, 20f));
        bodyElementCollection.add(new PhysicalMovementWalkRightStateProcessor(bodyElement, 20f));

        Collection<StateProcessor> visualElementCollection = new ArrayList<>();
        visualElement = new VisualComponent(texture, visualElementCollection, bodyElement);
        visualElementCollection.add(new AnimationIdleStateProcessor(visualElement, 0, getIdleFrames()));
        visualElementCollection.add(new AnimationWalkRightStateProcessor(visualElement, 0.3f, getWalkRightFrames()));
        visualElementCollection.add(new AnimationWalkLeftStateProcessor(visualElement, 0.3f, getWalkLeftFrames()));
    }

    @Override
    public void update() {
        stateElement.process(State.any);
        bodyElement.process(stateElement.value);
        visualElement.process(stateElement.value);
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
