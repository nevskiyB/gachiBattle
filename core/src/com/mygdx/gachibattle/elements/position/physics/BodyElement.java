package com.mygdx.gachibattle.elements.position.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;
import com.mygdx.gachibattle.elements.position.Position;

import java.util.Collection;

public class BodyElement extends Element<Body> implements Position {
    public BodyElement(Body initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }

    @Override
    public Vector2 getPosition() {
        return value.getPosition();
    }
}
