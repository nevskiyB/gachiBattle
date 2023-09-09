package com.mygdx.gachibattle.entity.utils;

import com.badlogic.gdx.Gdx;
import com.mygdx.gachibattle.entity.utils.state.ActionStatesPerformer;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.actions.ActionState;
import com.mygdx.gachibattle.entity.utils.state.State;
import com.mygdx.gachibattle.entity.utils.state.StateMachine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntity extends ComponentsHolder implements ActionStatesPerformer {
    public final List<ActionState> actions;
    public final StateMachine stateMachine;

    public AbstractEntity(StateMachine stateMachine) {
        super(new ArrayList<Component>());
        this.actions = new ArrayList<>();
        this.stateMachine = stateMachine;
    }

    @Override
    public void performActionStates() {
        State currentState = stateMachine.getState();
        for (ActionState act : actions) {
            act.execute(currentState);
        }
    }
}
