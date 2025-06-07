package com.characterduel;

public class Warrior extends Character {

    public Warrior() {
        super(15,10,1);
    }

    @Override
    protected void ultimate(Character enemy) {
        this.attackPoints = this.standardAttackPoints * 2;
    }
}
