package com.characterduel;

public class Archer extends Character {

    public Archer(int standardAttackPoints,int standardDefensePoints,int standardAttackRange, int team) {
        super(8,5,5,team);
    }

    protected void ultimate() {
        this.attackRange += standardAttackRange / 5;
    }
}
