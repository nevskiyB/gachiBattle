package com.mygdx.gachibattle.entity.utils.actions.exceptions;

import com.mygdx.gachibattle.entity.utils.ComponentsHolder;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;

public class ComponentMissingException extends Exception {
    public ComponentMissingException(ComponentType type, ComponentsHolder entity) {
        super("Mandatory component Type:'"+ type +"' not found! Entity:'" + entity.getClass().getSimpleName() + "'");
    }

    public ComponentMissingException(String message) {
        super(message);
    }
}
