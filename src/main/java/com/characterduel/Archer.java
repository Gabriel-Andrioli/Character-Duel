package com.characterduel;

public class Archer extends Character {

    public Archer() {
        super(8,5,5);
    }

    @Override
    protected void ultimate(Character enemy) {
        this.attackRange += standardAttackRange / 5;
    }
}
