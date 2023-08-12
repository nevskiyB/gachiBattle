package com.mygdx.gachibattle.entity.utils.components;


//Data holder
public abstract class Component<T> implements Enabled {
    public T value;
    public ComponentType type;
    public boolean enabled;

    public Component(T initValue, ComponentType type, boolean enabled) {
        value = initValue;
        this.type = type;
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
