package com.mygdx.gachibattle.components.state;

import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;

import java.util.Collection;


public class StateComponent extends Component<State> {
    public StateComponent(State initValue, Collection<StateProcessor> processorCollection) {
        super(initValue, processorCollection);
    }
}
