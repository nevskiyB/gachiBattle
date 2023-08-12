package com.mygdx.gachibattle.entity.utils.components.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.entity.utils.actions.Position;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;


public class BodyComponent extends Component<Body> implements Position {
    public BodyComponent(Body initValue) {
        this(initValue, true);
    }
    public BodyComponent(Body initValue, boolean enabled) {
        super(initValue, ComponentType.physicsBody, enabled);
    }

    @Override
    public Vector2 getPosition() {
        return value.getPosition();
    }
}
