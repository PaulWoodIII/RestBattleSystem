package com.paulwoodiii;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by paul on 10/2/16.
 */
public class BattleTest {

    ArrayList<Character> t1;
    ArrayList<Character> t2;

    class Punch extends Ability {
        @Override
        public void onAction(BattleState state, CharacterState actor, CharacterState primaryTarget) {
            super.onAction(state, actor, primaryTarget);
            int hp = primaryTarget.currentHP;
            primaryTarget.setCurrentHP(hp-10);
        }
    }

    @Before
    public void setUp() throws Exception {
        t1 = new ArrayList<>();
        t2 = new ArrayList<>();
        Character c1 = new Character();
        c1.setName("c1");
        Ability punch = new Punch();
        c1.abilities.add(punch);
        c1.baseSpeed = 0.2f;
        c1.maxHP = 110;

        Character c2 = new Character();
        c2.setName("c2");
        c2.abilities.add(punch);
        c2.baseSpeed = 0.1f;
        c2.maxHP = 100;

        t1.add(c1);
        t2.add(c2);
    }

    @Test
    public void simulateToEndOfActions() throws Exception {
        Battle b = new Battle();
        b.teams.add(t1);
        b.teams.add(t2);

        Action act1 = new Action(t1.get(0),t2.get(0),new Punch());
        b.actions.add(act1);

        BattleState state = Battle.simulateToEndOfActions(b);

        assertEquals(state.teams.get(1).get(0).currentHP,100);
        System.out.println(state);
    }

}