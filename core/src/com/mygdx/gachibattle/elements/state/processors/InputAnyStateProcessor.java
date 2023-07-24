package com.mygdx.gachibattle.elements.state.processors;

import com.mygdx.gachibattle.controllers.DefaultInputProcessor;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;


public class InputAnyStateProcessor extends StateProcessor {
    private final Element<State> stateElement;
    private final DefaultInputProcessor inputProcessor;

    public InputAnyStateProcessor(Element<State> stateElement, DefaultInputProcessor inputProcessor) {
        super(State.any);
        this.stateElement = stateElement;
        this.inputProcessor = inputProcessor;
    }

    @Override
    public void process() {
        stateElement.value = inputProcessor.getState();
    }
}
