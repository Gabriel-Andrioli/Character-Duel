package com.characterduel;

public class Character {
    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    protected int attackRange;
    protected int [] position;

    private boolean isInRange(Character enemy) {
        int distance = Math.max(Math.abs(enemy.position[0] - this.position[0]),
                Math.abs(enemy.position[1] - this.position[1]));
        return distance <= this.attackRange;
    }

    protected void attack(Character enemy) {

        /*
        if(!isInRange(enemy)) {
            Game.skipTurn();
            return;
            }
            */

        int damage = this.attackPoints;
        if(enemy.defensePoints > damage) {
            enemy.defensePoints -= damage;
            //Game.skipTurn();
        }

        else if (enemy.defensePoints > 0) {
            damage -= enemy.defensePoints ;
            enemy.defensePoints = 0;
            enemy.healthPoints -= damage;
            //Game.skipTurn();
        }

        else {
            enemy.healthPoints -= damage;
            //Game.skipTurn();
        }
    };
}
