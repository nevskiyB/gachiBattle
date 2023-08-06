package com.mygdx.gachibattle.components.position.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;
import com.mygdx.gachibattle.components.position.Position;

import java.util.Collection;

public class BodyComponent extends Component<Body> implements Position {
    public BodyComponent(Body initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }

    @Override
    public Vector2 getPosition() {
        return value.getPosition();
    }
}
