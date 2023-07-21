package com.mygdx.gachibattle.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gachibattle.controllers.controlsetup.ControlSetup;

public class DefaultInputProcessor extends InputAdapter implements MoveActionsAccessor, AttackActionsAccessor {
    private final ControlSetup setup;
    private boolean goLeft, goRight, doPunch, doStringPunch;

    public DefaultInputProcessor(ControlSetup setup) {
        this.setup = setup;
        goLeft = goRight = doPunch = doStringPunch = false;
    }

    @Override
    public boolean keyDown(int keycode) {
        setKey(keycode, true);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        setKey(keycode, false);
        return false;
    }

    private void setKey(int keycode, boolean value) {
        Gdx.app.log("Key", "Input: '" + Input.Keys.toString(keycode) + "'; Key down: " + value);

        //movement
        if(setup.getRight() == keycode)
            goRight = value;
        if(setup.getLeft() == keycode)
            goLeft = value;

        //attack
        if(setup.getPunch() == keycode)
            doPunch = value;
        if(setup.getStrongPunch() == keycode)
            doStringPunch = value;
    }

    @Override
    public boolean getDoPunch() {
        return doPunch;
    }

    @Override
    public boolean getDoStringPunch() {
        return doStringPunch;
    }

    @Override
    public boolean getGoLeft() {
        return goLeft;
    }

    @Override
    public boolean getGoRight() {
        return goRight;
    }
}
