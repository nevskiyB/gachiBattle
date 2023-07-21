package com.mygdx.gachibattle.controllers.controlsetup;

import com.badlogic.gdx.Input;


public class DefaultControlSetup implements ControlSetup {
    @Override
    public int getRight() {
        return Input.Keys.D;
    }

    @Override
    public int getLeft() {
        return Input.Keys.A;
    }

    @Override
    public int getPunch() {
        return Input.Keys.LEFT;
    }

    @Override
    public int getStrongPunch() {
        return Input.Keys.RIGHT;
    }
}
