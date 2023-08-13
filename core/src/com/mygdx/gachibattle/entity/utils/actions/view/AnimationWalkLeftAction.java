package com.mygdx.gachibattle.entity.utils.actions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gachibattle.entity.utils.AbstractEntity;
import com.mygdx.gachibattle.entity.utils.actions.Action;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;


public class AnimationWalkLeftAction implements Action {
    private final ViewComponent viewComponent;
    private final Animation<TextureRegion> animation;
    private float stateTime = 0f;
    public boolean enabled = true;

    public AnimationWalkLeftAction(AbstractEntity entity, float frameDuration, TextureRegion[] keyFrames) throws ComponentMissingException {
        this.viewComponent = (ViewComponent) entity.getComponent(ComponentType.view);
        this.animation = new Animation<>(frameDuration, keyFrames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    @Override
    public void execute() {
        viewComponent.value = animation.getKeyFrame(stateTime);
        stateTime += Gdx.graphics.getDeltaTime();
    }

    @Override
    public boolean isEnabled() {
        return viewComponent.enabled && enabled;
    }
}
