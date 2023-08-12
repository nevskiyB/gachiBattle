package com.mygdx.gachibattle.entity.utils.actions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gachibattle.entity.utils.ComponentsHolder;
import com.mygdx.gachibattle.entity.utils.actions.Action;
import com.mygdx.gachibattle.entity.utils.actions.Position;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.ComponentMissingException;
import com.mygdx.gachibattle.entity.utils.actions.exceptions.PositionComponentNotFoundException;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;
import com.mygdx.gachibattle.updater.render.Render;


public class DrawAction implements Action {
    private final ViewComponent viewComponent;
    private final Position position;
    private final SpriteBatch batch;

    public boolean enabled = true;

    public DrawAction(ComponentsHolder entity) throws ComponentMissingException {
        this.viewComponent = (ViewComponent) entity.getComponent(ComponentType.view);
        position = getPosition(entity);
        batch = Render.INSTANCE.batch;
    }

    @Override
    public void execute() {
        batch.draw(viewComponent.value, position.getPosition().x, position.getPosition().y);
    }

    @Override
    public boolean isEnabled() {
        return viewComponent.enabled && enabled;
    }

    private Position getPosition(ComponentsHolder entity) throws ComponentMissingException, PositionComponentNotFoundException {
        if(entity.isExist(ComponentType.physicsBody)) {
            return (Position)entity.getComponent(ComponentType.physicsBody);
        }
        if(entity.isExist(ComponentType.position)) {
            return (Position)entity.getComponent(ComponentType.position);
        }

        throw new PositionComponentNotFoundException(entity);
    }
}
