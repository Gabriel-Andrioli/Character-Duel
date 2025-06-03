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

    private void attackBattleLog(Character enemy, int argDamageDealt) {
        if(argDamageDealt > 0)
            System.out.print("You hit your enemy for " + argDamageDealt + " points of damage!");
        else
            System.out.print("Your enemy was too far and you missed...");
        System.out.print(this.name + "'s HP: " + this.healthPoints
                + "\t" + this.name + "'s DP: " + this.defensePoints);
        System.out.print(enemy.name + "'s HP: " + enemy.healthPoints
                + "\t" + enemy.name + "'s DP: " + enemy.defensePoints);
    }

    protected void attack(Character enemy) {

        int damageDealt = this.attackPoints;

        if(!isInRange(enemy)) {
            System.out.print("Your enemy was too far and you missed...");
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
            }

        else if(enemy.defensePoints > damageDealt) {
            enemy.defensePoints -= damageDealt;
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
        }

        else if (enemy.defensePoints > 0) {
            damageDealt -= enemy.defensePoints ;
            enemy.defensePoints = 0;
            enemy.healthPoints -= damageDealt;
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
        }

        else {
            enemy.healthPoints -= damageDealt;
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
        }
    }
}
