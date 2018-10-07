package base.action;

import base.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionSequence extends Action{
    ArrayList<Action> actions;
    int currentActionIndex;
    public ActionSequence(Action... actions){
        this.actions = new ArrayList<>(Arrays.asList(actions));
        this.currentActionIndex = 0;

    }
    public void run(GameObject master){
        if(this.actions.size() > 0 && this.currentActionIndex < this.actions.size() && !this.isDone){
            Action currentAction = this.actions.get(this.currentActionIndex);
            if(!currentAction.isDone){
                currentAction.run(master);
            }else {
                this.currentActionIndex++;
            }
        }
    }
}

