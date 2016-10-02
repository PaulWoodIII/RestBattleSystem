package com.paulwoodiii;

import java.util.ArrayList;

/**
 * Created by paul on 10/2/16.
 */
public class Character {
    /**
     * The Characters Name
     */
    String name;
    /**
     * What the Character can do during their turn
     */
    ArrayList<Ability> abilities;
    /**
     * How many Hitpoints the character has at the beginnign of the fight
     */
    int maxHP;
    /**
     * How much the turn meter grows per tick
     */
    float baseSpeed;

    public Character() {
        abilities = new ArrayList<>();
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public int getMaxHP() {
        return maxHP;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
