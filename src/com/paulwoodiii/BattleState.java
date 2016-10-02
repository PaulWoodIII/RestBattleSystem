package com.paulwoodiii;

import java.util.ArrayList;

/**
 * Created by paul on 10/2/16.
 */
public class BattleState {
    /**
     * The Two teams battling
     */
    ArrayList<ArrayList<CharacterState>> teams;//Must only be 2!

    /**
     * What actions have occured
     */
    ArrayList<Action> actions;

    /**
     * Time the game started which will be used used for random seed
     */
    int timeStarted;

    public BattleState(Battle b) {
        this.teams = new ArrayList<>();
        for (int i = 0; i < b.teams.size(); i++) {
            ArrayList<Character> t = b.teams.get(i);
            this.teams.add(new ArrayList<>());
            for (Character c:t) {
                CharacterState cs = new CharacterState(c);
                this.teams.get(i).add(cs);
            }
        }
        this.actions = new ArrayList<>();

    }

    public int turnsTaken(){
        return actions.size();
    }

    /**
     * Times the tick function has been called on the characters in the battle
     */
    int ticksTaken;

    /**
     * Helper to know who should have the next action
     *
     * Calculation of this will affect ticks taken
     */
    CharacterState nextActor;

    public ArrayList<ArrayList<CharacterState>> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<ArrayList<CharacterState>> teams) {
        this.teams = teams;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public int getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(int timeStarted) {
        this.timeStarted = timeStarted;
    }


    public int getTicksTaken() {
        return ticksTaken;
    }

    public void setTicksTaken(int ticksTaken) {
        this.ticksTaken = ticksTaken;
    }
}
