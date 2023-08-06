package com.mygdx.gachibattle.components;

import com.mygdx.gachibattle.controllers.State;

public abstract class StateProcessor {
    public final State state;

    protected StateProcessor(State processorState) {
        this.state = processorState;
    }

    public abstract void process();
}
