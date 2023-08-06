package com.mygdx.gachibattle.components.visual.processors;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.components.Component;
import com.mygdx.gachibattle.components.StateProcessor;

@Deprecated
public class RenderAnyStateProcessor extends StateProcessor {
    private final Component<Texture> textureElement;

    public RenderAnyStateProcessor(Component<Texture> textureElement) {
        super(State.any);
        this.textureElement = textureElement;
    }

    @Override
    public void process() {
        //TODO: setting animation frame to Texture
    }
}
