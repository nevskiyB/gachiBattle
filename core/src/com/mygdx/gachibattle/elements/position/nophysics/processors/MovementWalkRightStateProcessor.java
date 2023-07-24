package com.mygdx.gachibattle.elements.position.nophysics.processors;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;


public class MovementWalkRightStateProcessor extends StateProcessor {
    private final Element<Vector2> positionElement;
    private final float step;

    public MovementWalkRightStateProcessor(Element<Vector2> positionElement, float step) {
        super(State.walkRight);
        this.positionElement = positionElement;
        this.step = step;
    }

    @Override
    public void process() {
        positionElement.value.x += step;
    }
}
