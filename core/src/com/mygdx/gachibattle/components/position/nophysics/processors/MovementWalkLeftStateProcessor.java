package com.mygdx.gachibattle.components.position.nophysics.processors;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;


public class MovementWalkLeftStateProcessor extends StateProcessor {
    private final Component<Vector2> positionElement;
    private final float step;

    public MovementWalkLeftStateProcessor(Component<Vector2> positionElement, float step) {
        super(State.walkLeft);
        this.positionElement = positionElement;
        this.step = step;
    }

    @Override
    public void process() {
        positionElement.value.x -= step;
    }
}
