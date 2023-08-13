package com.mygdx.gachibattle.entity.utils;

import com.badlogic.gdx.Gdx;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;

import java.util.List;

public class ComponentsHolder {
    public final List<Component> components;

    public ComponentsHolder(List<Component> components) {
        this.components = components;
    }

    public Component getComponent(ComponentType type) throws ComponentMissingException {
        for (Component component : components) {
            if (component.type == type) {
                return component;
            }
        }
        Gdx.app.error("Component not found!", "Component type:'" + type + "', of Entity:'" + this.getClass().getSimpleName() + "'");
        throw new ComponentMissingException(type, this);
    }

    public boolean isExist(ComponentType type) {
        for (Component component : components) {
            if (component.type == type) {
                return true;
            }
        }
        return false;
    }
}
