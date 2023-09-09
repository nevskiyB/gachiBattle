package com.mygdx.gachibattle.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.ActionState;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.physics.PhysicalMovementWalkRightAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationIdleAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkLeftAction;
import com.mygdx.gachibattle.entity.utils.actions.view.AnimationWalkRightAction;
import com.mygdx.gachibattle.entity.utils.actions.view.DrawAction;
import com.mygdx.gachibattle.entity.utils.components.physics.BodyComponent;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;
import com.mygdx.gachibattle.entity.utils.state.State;
import com.mygdx.gachibattle.entity.utils.state.StateMachine;
import com.mygdx.gachibattle.loader.TextureLoader;
import com.mygdx.gachibattle.updater.physics.Physics;

import java.util.List;

public class Player extends AbstractEntity implements Disposable  {
    private final PlayerBody body;
    private final PlayerLegs legs;

    public Player(Vector2 initPosition, StateMachine stateMachine) {
        super(stateMachine);

        //Components
        TextureRegion idleRightBodyTextureRegion = new TextureRegion(new Texture("billy/idle/right.png"));
        components.add(new ViewComponent(idleRightBodyTextureRegion));
        components.add(new BodyComponent(getBody(initPosition,
                new Vector2(idleRightBodyTextureRegion.getTexture().getWidth(),
                        idleRightBodyTextureRegion.getTexture().getHeight()),
                BodyDef.BodyType.DynamicBody,
                100f)));

        body = new PlayerBody(actions, this);
        legs = new PlayerLegs(actions, this);
    }

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

    @Override
    public void dispose() {

    }

    private static class PlayerBody {
        public PlayerBody(List<ActionState> actions, AbstractEntity entity) {
            //Actions
            try {
                actions.add(new ActionState(new DrawAction(entity)));
                actions.add(new ActionState(State.walkRight,
                        new PhysicalMovementWalkRightAction(entity, 20f),
                        new AnimationWalkRightAction(entity, 0.3f,
                                TextureLoader.getFrames("billy/run/m1887_right_run_set.png", 6, 1))));
                actions.add(new ActionState(State.walkLeft,
                        new PhysicalMovementWalkLeftAction(entity, 20f),
                        new AnimationWalkLeftAction(entity, 0.3f,
                                TextureLoader.getFrames("billy/run/m1887_right_run_set.png", 6, 1))));
                actions.add(new ActionState(State.idleRight,
                        new AnimationIdleAction(entity, 0f,
                                TextureLoader.getFrames("billy/idle/right.png", 1, 1))));
                actions.add(new ActionState(State.idleLeft,
                        new AnimationIdleAction(entity, 0f,
                                TextureLoader.getFrames("billy/idle/right.png", 1, 1))));
            }
            catch (ComponentMissingException e) {
                Gdx.app.error("Initialization error", e.getMessage());
                Gdx.app.exit();
            }
        }
    }

    private static class PlayerLegs {
        public PlayerLegs(List<ActionState> actions, AbstractEntity entity) {
            //Actions
            try {
                actions.add(new ActionState(new DrawAction(entity)));
                actions.add(new ActionState(State.walkRight,
                        new PhysicalMovementWalkRightAction(entity, 20f),
                        new AnimationWalkRightAction(entity, 0.3f,
                                TextureLoader.getFrames("billy/run/run_legs.png", 6, 1))));
                actions.add(new ActionState(State.walkLeft,
                        new PhysicalMovementWalkLeftAction(entity, 20f),
                        new AnimationWalkLeftAction(entity, 0.3f,
                                TextureLoader.getFrames("billy/run/run_legs.png", 6, 1))));
                actions.add(new ActionState(State.idleRight,
                        new AnimationIdleAction(entity, 0f,
                                TextureLoader.getFrames("billy/idle/legs.png", 1, 1))));
                actions.add(new ActionState(State.idleLeft,
                        new AnimationIdleAction(entity, 0f,
                                TextureLoader.getFrames("billy/idle/legs.png", 1, 1))));
            }
            catch (ComponentMissingException e) {
                Gdx.app.error("Initialization error", e.getMessage());
                Gdx.app.exit();
            }
        }
    }
}
