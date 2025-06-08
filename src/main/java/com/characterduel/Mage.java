package com.characterduel;

public class Mage extends Character {

    public Mage() {
        super(10,7,3,100);
    }

    @Override
    protected void ultimate(Character enemy) {
        int aux = this.healthPoints;
        this.healthPoints = enemy.healthPoints;
        enemy.healthPoints = aux;
    }
}
