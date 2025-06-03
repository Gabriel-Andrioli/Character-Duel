package com.characterduel;

public class Archer extends Character {
    protected int standardDefensePoints;
    protected int standardHealthPoints;
    protected int standardAttackPoints;
    protected int standardAttackRange;

    public Archer() {
        defensePoints = standardDefensePoints = 5;
        healthPoints = standardHealthPoints = 100;
        attackPoints = standardAttackPoints = 8;
        attackRange = standardAttackRange = 5;
    }

    protected void defend() {
        this.defensePoints = this.standardDefensePoints;
    }

    protected void ultimate() {
        this.attackRange += standardAttackRange / 5;
    }
}
