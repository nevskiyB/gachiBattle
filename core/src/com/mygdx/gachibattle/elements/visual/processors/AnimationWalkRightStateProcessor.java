package com.mygdx.gachibattle.elements.visual.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import com.mygdx.gachibattle.controllers.State;
import com.mygdx.gachibattle.elements.Element;
import com.mygdx.gachibattle.elements.StateProcessor;


public class AnimationWalkRightStateProcessor extends StateProcessor {
    private final Element<Texture> textureElement;
    private final Animation<Texture> animation;
    private float stateTime = 0f;

    public AnimationWalkRightStateProcessor(Element<Texture> textureElement, float frameDuration, Array<Texture> keyFrames) {
        super(State.walkRight);
        this.textureElement = textureElement;
        this.animation = new Animation<>(frameDuration, keyFrames, Animation.PlayMode.LOOP);
    }

    @Override
    public void process() {
        textureElement.value = animation.getKeyFrame(stateTime);
        stateTime += Gdx.graphics.getDeltaTime();
    }
}
