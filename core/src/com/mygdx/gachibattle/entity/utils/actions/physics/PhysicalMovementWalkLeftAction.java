package com.mygdx.gachibattle.entity.utils.actions.physics;

import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.Action;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.entity.utils.components.physics.BodyComponent;


public class PhysicalMovementWalkLeftAction implements Action {
    private final BodyComponent bodyComponent;
    private final float velocityX;
    public boolean enabled = true;

    public PhysicalMovementWalkLeftAction(AbstractEntity entity, float velocityX) throws ComponentMissingException {
        bodyComponent = (BodyComponent) entity.getComponent(ComponentType.physicsBody);
        this.velocityX = velocityX;
    }

    @Override
    public void execute() {
        bodyComponent.value.setLinearVelocity(-velocityX, bodyComponent.value.getLinearVelocity().y);
    }

    @Override
    public boolean isEnabled() {
        return bodyComponent.enabled && enabled;
    }
}
