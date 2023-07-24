package com.mygdx.gachibattle.elements.state;

import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;

import java.util.Collection;


public class StateElement extends Element<State> {
    public StateElement(State initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }
}
