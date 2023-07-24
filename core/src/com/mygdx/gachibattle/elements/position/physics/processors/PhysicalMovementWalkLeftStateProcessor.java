package com.mygdx.gachibattle.elements.position.physics.processors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;


public class PhysicalMovementWalkLeftStateProcessor extends StateProcessor {
    private final Element<Body> bodyElement;
    private final float velocityX;

    public PhysicalMovementWalkLeftStateProcessor(Element<Body> bodyElement, float velocityX) {
        super(State.walkLeft);
        this.bodyElement = bodyElement;
        this.velocityX = velocityX;
    }

    @Override
    public void process() {
        bodyElement.value.setLinearVelocity(-velocityX, bodyElement.value.getLinearVelocity().y);
    }
}
