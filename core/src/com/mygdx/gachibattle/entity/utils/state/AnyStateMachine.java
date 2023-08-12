package com.mygdx.gachibattle.entity.utils.state;

public class AnyStateMachine implements StateMachine{
    @Override
    public State getState() {
        return State.any;
    }
}
