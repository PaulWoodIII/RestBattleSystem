package com.paulwoodiii;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by paul on 10/2/16.
 */
public class Battle {
    /**
     * <p>
     *     Must only be 2 teams.
     * </p>
     */
    ArrayList<ArrayList<Character>> teams;
    ArrayList<Action> actions;
    long timeStarted; //used for random number generation

    public Battle() {
        teams = new ArrayList<>();
        actions = new ArrayList<>();
        long timeStarted = new Date().getTime();
    }

    public static BattleState simulateToEndOfActions(Battle b) throws BattleStateError {
        BattleState state = new BattleState(b);
        state.setActions(b.actions);

        //Progress until Character can make an action
        progressTicksUntilActionable(state);

        for (Action action : b.actions) {
            //Ensure the first action is the same character as simulation dictates or throw
            if (action.character != state.nextActor.character) {
                throw new BattleStateError();
            }

            //Take CharacterState's Before Action
            state.nextActor.beforeAction(state);

            //Take Action
            {
                //Before
                action.beforeAction(state);
                //Act
                action.onAction(state);
                //After
                action.afterAction(state);
            }

            //Take CharacterState After Action
            state.nextActor.afterAction(state);
        }
        return state;
    }

    private static BattleState progressTicksUntilActionable(BattleState b) throws BattleStateError {
        ArrayList<CharacterState> readyToAct = new ArrayList<>();
        for (ArrayList<CharacterState> team : b.teams) {
            for(CharacterState c : team){
                if (c.currentSpeedMeter >= 1.0){
                    readyToAct.add(c);
                }
            }
        }
        if(readyToAct.size() > 0){
            readyToAct.sort( (a, c) -> Float.compare(a.currentSpeedMeter, c.currentSpeedMeter));
            b.nextActor = readyToAct.get(readyToAct.size()-1);
            return b;
        }
        float topSpeed = 0.0f;
        while (topSpeed < 1.0) {
            readyToAct.clear();
            for (ArrayList<CharacterState> team : b.teams) {
                for (CharacterState c : team) {
                    c.applyTick();
                    readyToAct.add(c);
                }
            }
            readyToAct.sort((a, c) -> Float.compare(a.currentSpeedMeter, c.currentSpeedMeter));
            CharacterState c = readyToAct.get(readyToAct.size()-1);
            topSpeed = c.currentSpeedMeter;
            b.ticksTaken++;

        }

        b.nextActor = readyToAct.get(readyToAct.size() - 1);
        return b;
    }

    public static boolean canAddAction(Battle b, Action a){
        return true;
    }

    public static class BattleStateError extends Exception {

    }
}
