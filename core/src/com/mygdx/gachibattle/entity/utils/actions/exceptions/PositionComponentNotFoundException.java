package com.mygdx.gachibattle.entity.utils.actions.exceptions;

import com.mygdx.gachibattle.entity.utils.ComponentsHolder;

public class PositionComponentNotFoundException extends ComponentMissingException {
    public PositionComponentNotFoundException(ComponentsHolder entity) {
        super("Position component not found for entity:'" + entity.getClass().getSimpleName() +"'");
    }
}
