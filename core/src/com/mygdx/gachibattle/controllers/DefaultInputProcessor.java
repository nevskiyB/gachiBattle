package com.mygdx.gachibattle.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gachibattle.controllers.controlsetup.ControlSetup;

public class DefaultInputProcessor extends InputAdapter {
    private final ControlSetup setup;
    private State state;

    public DefaultInputProcessor(ControlSetup setup) {
        this.setup = setup;
        state = State.idle;
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

    private void setKey(int keycode, boolean isKeyDown) {
        //movement
        if(isKeyDown) {
            if (setup.getRight() == keycode)
                state = State.walkRight;
            if (setup.getLeft() == keycode)
                state = State.walkLeft;
        } else {
            state = State.idle;
        }

        //Gdx.app.log("Key", "Input: '" + Input.Keys.toString(keycode) + "'; Key down: " + isKeyDown);
        Gdx.app.log("State", state.toString());
    }

    public State getState() {
        return state;
    }
}
