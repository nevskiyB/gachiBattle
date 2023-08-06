package com.mygdx.gachibattle.components.position.physics.processors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;


public class PhysicalMovementWalkRightStateProcessor extends StateProcessor {
    private final Component<Body> bodyElement;
    private final float velocityX;

    public PhysicalMovementWalkRightStateProcessor(Component<Body> bodyElement, float velocityX) {
        super(State.walkRight);
        this.bodyElement = bodyElement;
        this.velocityX = velocityX;
    }

    @Override
    public void process() {
        bodyElement.value.setLinearVelocity(velocityX, bodyElement.value.getLinearVelocity().y);
    }
}
