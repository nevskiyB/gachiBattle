package com.mygdx.gachibattle.components.position.nophysics;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;
import com.mygdx.gachibattle.components.position.Position;

import java.util.Collection;

public class PositionComponent extends Component<Vector2> implements Position {
    public PositionComponent(Vector2 initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }

    @Override
    public Vector2 getPosition() {
        return value;
    }
}
