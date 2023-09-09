package com.mygdx.gachibattle.entity.utils.actions;

import com.badlogic.gdx.Gdx;
import com.mygdx.gachibattle.entity.utils.state.State;

import java.util.Arrays;
import java.util.List;

public class ActionState {
    public final State state;
    public final List<Action> actionsForState;


    public ActionState(Action ... acts) {
        this(State.any, acts);
    }

    public ActionState(State state, Action ... acts) {
        this.state = state;
        this.actionsForState = Arrays.asList(acts);
    }

    public void execute(State activeEntityState) {

        if(state == State.any || state == activeEntityState) {
            for (Action act : actionsForState ) {
                Gdx.app.log("Action: " + act.getTag(), "");
                if(act.isEnabled()) {
                    act.execute();
                }
            }
        }
    }
}
