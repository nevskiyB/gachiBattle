package com.mygdx.gachibattle.entity.utils.components.view;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gachibattle.entity.utils.components.Component;
import com.mygdx.gachibattle.entity.utils.components.ComponentType;
import com.mygdx.gachibattle.updater.render.Render;


public class ViewComponent extends Component<Texture> {
    public ViewComponent(Texture initValue) {
        this(initValue, true);
    }
    public ViewComponent(Texture initValue, boolean enabled) {
        super(initValue, ComponentType.view, enabled);
        Render.INSTANCE.visualElementList.add(this);
    }
}
