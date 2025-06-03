package com.characterduel;

public class Warrior extends Character {
    protected int standardDefensePoints;
    protected int standardHealthPoints;
    protected int standardAttackPoints;
    protected int standardAttackRange;

    public Warrior() {
        defensePoints = standardDefensePoints = 10;
        healthPoints = standardHealthPoints = 100;
        attackPoints = standardAttackPoints = 15;
        attackRange = standardAttackRange = 1;
    }

    protected void defend() {
        this.defensePoints = this.standardDefensePoints;
    }

    protected void ultimate(Character enemy) {
        this.attackPoints = this.standardAttackPoints * 2;
    }
}
