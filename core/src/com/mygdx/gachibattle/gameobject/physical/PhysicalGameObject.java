package com.mygdx.gachibattle.gameobject.physical;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.gachibattle.gameobject.GameObject;

public interface PhysicalGameObject extends GameObject {
    Body getBody();
}
