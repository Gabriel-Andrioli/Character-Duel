package com.characterduel;

public class Mage extends Character {
    protected int standardDefensePoints;
    protected int standardHealthPoints;
    protected int standardAttackPoints;
    protected int standardAttackRange;

    public Mage() {
        defensePoints = standardDefensePoints = 7;
        healthPoints = standardHealthPoints = 100;
        attackPoints = standardAttackPoints = 10;
        attackRange = standardAttackRange = 3;
    }

    protected void defend() {
        this.defensePoints = this.standardDefensePoints;
    }

    protected void ultimate(Character enemy) {
        int aux = this.healthPoints;
        this.healthPoints = enemy.healthPoints;
        enemy.healthPoints = aux;
    }
}
