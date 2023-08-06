package com.mygdx.gachibattle.components.visual;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gachibattle.updater.render.Render;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;
import com.mygdx.gachibattle.components.position.Position;

import java.util.Collection;


public class VisualComponent extends Component<Texture> {
    public Position position;
    public VisualComponent(Texture initValue, Collection<StateProcessor> processorCollection, Position position) {
        super(initValue, processorCollection);
        this.position = position;
        Render.INSTANCE.visualElementList.add(this);
    }
}
