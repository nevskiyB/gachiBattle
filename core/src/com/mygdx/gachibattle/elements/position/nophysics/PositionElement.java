package com.mygdx.gachibattle.elements.position.nophysics;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;
import com.mygdx.gachibattle.elements.position.Position;

import java.util.Collection;

public class PositionElement extends Element<Vector2> implements Position {
    public PositionElement(Vector2 initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }

    @Override
    public Vector2 getPosition() {
        return value;
    }
}
