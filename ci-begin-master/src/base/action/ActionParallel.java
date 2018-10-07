package base.action;

import base.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionParallel extends Action {
    ArrayList<Action> actions;
    public ActionParallel(Action... actions){
        this.actions = new ArrayList<>(Arrays.asList(actions));
    }

    public void run(GameObject master){
        if (this.actions.size()>0 && !this.isDone){
            boolean check = true;
            for (Action action : actions) {
                if (!action.isDone) {
                    action.run(master);
                }else {
                    check = false;
                }
            }
        }
    }
}
