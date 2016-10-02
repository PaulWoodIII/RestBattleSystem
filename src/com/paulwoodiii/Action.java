package com.paulwoodiii;

import java.util.ArrayList;

/**
 * An instance of a Character using an Ability on another Character
 */
public class Action {
    Character character;
    Character target;
    Ability ability;

    public Action(Character character, Character target, Ability ability) {
        this.character = character;
        this.target = target;
        this.ability = ability;
    }

    public Action() {
    }

    public CharacterState findCharacter(BattleState state){
        for (ArrayList<CharacterState> list : state.teams) {
            for (CharacterState c : list) {
                if(c.character == this.character){
                    return c;
                }
            }
        }
        return null;
    }

    public CharacterState findTarget(BattleState state){
        for (ArrayList<CharacterState> list : state.teams) {
            for (CharacterState c : list) {
                if(c.character == this.character){
                    return c;
                }
            }
        }
        return null;
    }

    public void beforeAction(BattleState state){
        CharacterState act = findCharacter(state);
        CharacterState tar = findTarget(state);
        this.ability.beforeAction(state,act,tar);
    }

    public void onAction(BattleState state){
        CharacterState act = findCharacter(state);
        CharacterState tar = findTarget(state);
        this.ability.onAction(state,act,tar);
    }

    public void afterAction(BattleState state){
        CharacterState act = findCharacter(state);
        CharacterState tar = findTarget(state);
        this.ability.afterAction(state,act,tar);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getTarget() {
        return target;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
