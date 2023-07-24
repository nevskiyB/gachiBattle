package com.mygdx.gachibattle.elements;


import com.mygdx.gachibattle.controllers.State;

import java.util.Collection;

public abstract class Element<V>  {
    public V value; //data
    protected Collection<StateProcessor> processorCollection; //actions

    public Element(V initValue, Collection<StateProcessor> processorCollection) {
        value = initValue;
        this.processorCollection = processorCollection;
    }

    public void process(State state) {
        for (StateProcessor processor : processorCollection)
            if (processor.state == state || processor.state == State.any)
                processor.process();
    }
}