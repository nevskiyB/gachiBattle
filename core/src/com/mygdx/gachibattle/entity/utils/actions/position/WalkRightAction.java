package com.mygdx.gachibattle.entity.utils.actions.position;

import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.Action;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.entity.utils.components.position.PositionComponent;


public class WalkRightAction implements Action {
    public float step;
    public boolean enabled = true;
    private final PositionComponent position;
    public WalkRightAction(AbstractEntity entity, float step) throws ComponentMissingException {
        this.step = step;
        position = (PositionComponent) entity.getComponent(ComponentType.position);
    }
    @Override
    public void execute() {
        position.value.x += step;
    }

    @Override
    public boolean isEnabled() {
        return position.enabled && enabled;
    }
}
