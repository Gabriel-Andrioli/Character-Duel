package com.characterduel;

import javax.swing.JOptionPane;

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

        if(!isInRange(enemy)) {
            JOptionPane.showMessageDialog(null, "Your enemy was too far and you missed...");
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

    protected void giveName(String name) {
        this.name = name;
    }
}
