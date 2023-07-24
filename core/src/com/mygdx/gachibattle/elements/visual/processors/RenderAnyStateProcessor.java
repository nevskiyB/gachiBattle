package com.mygdx.gachibattle.elements.visual.processors;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;

@Deprecated
public class RenderAnyStateProcessor extends StateProcessor {
    private final Element<Texture> textureElement;

    public RenderAnyStateProcessor(Element<Texture> textureElement) {
        super(State.any);
        this.textureElement = textureElement;
    }

    @Override
    public void process() {
        //TODO: setting animation frame to Texture
    }
}
