package com.characterduel;

public class Warrior extends Character {

    public Warrior(int standardAttackPoints,int standardDefensePoints,int standardAttackRange, int team) {
        super(15,10,1,team);
    }

    protected void ultimate(Character enemy) {
        this.attackPoints = this.standardAttackPoints * 2;
    }
}
