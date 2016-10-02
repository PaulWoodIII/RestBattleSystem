package com.paulwoodiii;

import java.util.ArrayList;

/**
 * Created by paul on 10/2/16.
 */
public class CharacterState{
    /**
     * The Character this State is for
     */
    Character character;

    public CharacterState(Character c) {
        this.character = c;
        this.effects = new ArrayList<>();
        this.currentHP = c.maxHP;
        this.currentSpeed = c.baseSpeed;
        this.currentSpeedMeter = 0.0f;
        this.isDead = false;
    }

    /**
     * Persistant effects on the character
     */
    ArrayList<StatusEffect> effects;
    /**
     * Current Hit Points
     */
    int currentHP;

    /**
     * current Max HP
     *
     * some effects may increase or decrease this maximum and scale the hitpoints of the character occordingly
     */
    int currentMaxHP;


    /**
     * current amount of turn meter gain per tick
     */
    float currentSpeed;

    /**
     * It is the characters turn when the speed meter reaches 1.0f
     *
     * Speed is added to the meter after each tick
     */
    float currentSpeedMeter;

    /**
     * If this character still in the battle
     */
    boolean isDead;

    /**
     * Apply the current Speed to the CharacterState
     */
    public void applyTick(){
        this.currentSpeedMeter = this.currentSpeedMeter + this.currentSpeed;
    }

    public void beforeAction(BattleState state){

    }

    public void afterAction(BattleState state){

    }

    /**
     * Helpers that ask the character about state
     */

    /**
     * Get the default or base speed of the character this state reprsents
     * @return float
     */
    public float getBaseSpeed(){
        return character.baseSpeed;
    }

    public int getMaxHP() {
        return character.getMaxHP();
    }

    public boolean canUseAbility (Ability a){
        return true;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public ArrayList<StatusEffect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<StatusEffect> effects) {
        this.effects = effects;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
