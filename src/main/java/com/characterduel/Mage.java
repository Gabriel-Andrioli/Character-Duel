package com.characterduel;

public class Mage extends Character {

    public Mage(int standardAttackPoints,int standardDefensePoints,int standardAttackRange, int team) {
        super(10,7,3);
    }

    protected void ultimate(Character enemy) {
        int aux = this.healthPoints;
        this.healthPoints = enemy.healthPoints;
        enemy.healthPoints = aux;
    }
}
