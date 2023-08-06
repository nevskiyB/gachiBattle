package com.mygdx.gachibattle.components.state.processors;

import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;


public class InputAnyStateProcessor extends StateProcessor {
    private final Component<State> stateElement;
    private final DefaultInputProcessor inputProcessor;

    public InputAnyStateProcessor(Component<State> stateElement, DefaultInputProcessor inputProcessor) {
        super(State.any);
        this.stateElement = stateElement;
        this.inputProcessor = inputProcessor;
    }

    @Override
    public void process() {
        stateElement.value = inputProcessor.getState();
    }
}
