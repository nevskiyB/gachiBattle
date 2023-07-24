package com.mygdx.gachibattle.elements.visual;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gachibattle.updater.Render;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;
import com.mygdx.gachibattle.elements.position.Position;

import java.util.Collection;


public class VisualElement extends Element<Texture> {
    public Position position;
    public VisualElement(Texture initValue, Collection<StateProcessor> processorCollection, Position position) {
        super(initValue, processorCollection);
        this.position = position;
        Render.INSTANCE.visualElementList.add(this);
    }
}
