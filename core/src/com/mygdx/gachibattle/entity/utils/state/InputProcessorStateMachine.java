package com.mygdx.gachibattle.entity.utils.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gachibattle.controllers.controlsetup.ControlSetup;

public class InputProcessorStateMachine extends InputAdapter implements StateMachine {
    private final ControlSetup setup;
    public State state = State.idleRight;

    public InputProcessorStateMachine(ControlSetup setup) {
        this.setup = setup;
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
            if(state == State.walkRight)
                state = State.idleRight;
            if(state == State.walkLeft)
                state = State.idleLeft;
        }

        Gdx.app.log("State", state.toString());
    }

    @Override
    public State getState() {
        return state;
    }
}
