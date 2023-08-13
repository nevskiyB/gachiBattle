package com.mygdx.gachibattle.entity.utils.components.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.updater.render.Render;


public class ViewComponent extends Component<TextureRegion> {
    public ViewComponent(TextureRegion initValue) {
        this(initValue, true);
    }
    public ViewComponent(TextureRegion initValue, boolean enabled) {
        super(initValue, ComponentType.view, enabled);
        Render.INSTANCE.visualElementList.add(this);
    }
}
