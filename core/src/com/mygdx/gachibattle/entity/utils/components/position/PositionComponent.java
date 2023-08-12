package com.mygdx.gachibattle.entity.utils.components.position;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gachibattle.entity.utils.actions.Position;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;


public class PositionComponent extends Component<Vector2> implements Position {
    public PositionComponent(Vector2 initPosition) {
        this(initPosition, true);
    }
    public PositionComponent(Vector2 initPosition, boolean enabled) {
        super(initPosition, ComponentType.position, enabled);
    }

    @Override
    public Vector2 getPosition() {
        return value;
    }
}
