package com.characterduel;

import javax.swing.JOptionPane;

public class Character {
    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    protected int attackRange;

    protected int standardDefensePoints;
    protected int standardHealthPoints = 100;
    protected int standardAttackPoints;
    protected int standardAttackRange;

    protected int [] position = new int [2];

    public Character(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int team) {
        healthPoints = standardHealthPoints;
        attackPoints = standardAttackPoints;
        defensePoints = standardDefensePoints;
        attackRange = standardAttackRange;
    }

    private void attackBattleLog(Character enemy, int argDamageDealt) {
        if(argDamageDealt > 0)
            JOptionPane.showMessageDialog(null, "You hit your enemy for " + argDamageDealt + " points of damage!");
        else
            JOptionPane.showMessageDialog(null, "Your enemy was too far and you missed...");
        JOptionPane.showMessageDialog(null, this.name + "'s HP: " + this.healthPoints
                + "\t" + this.name + "'s DP: " + this.defensePoints);
        JOptionPane.showMessageDialog(null, enemy.name + "'s HP: " + enemy.healthPoints
                + "\t" + enemy.name + "'s DP: " + enemy.defensePoints);
    }

    protected void attack(Character enemy) {

        int damageDealt = this.attackPoints;

        if(!Board.isInRange(this,enemy)) {
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
            }

        else if(enemy.defensePoints > damageDealt) {
            enemy.defensePoints -= damageDealt;
            attackBattleLog(enemy, damageDealt);
            //Game.skipTurn();
        }

        else if (enemy.defensePoints > 0) {
            damageDealt -= enemy.defensePoints;
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

    protected void defend() {
        this.defensePoints = this.standardDefensePoints;
    }

    protected boolean isAlive() {
        return this.healthPoints > 0;
    }

    protected void move() {

    }

    protected void giveName(String name) {
        this.name = name;
    }
}
