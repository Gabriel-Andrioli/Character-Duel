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

    public Character(int standardAttackPoints, int standardDefensePoints, int standardAttackRange) {
        this.standardHealthPoints = healthPoints = standardHealthPoints;
        this.standardAttackPoints = attackPoints = standardAttackPoints;
        this.standardDefensePoints = defensePoints = standardDefensePoints;
        this.standardAttackRange = attackRange = standardAttackRange;
    }

    private void attackBattleLog(Character enemy, int argDamageDealt) {
        if(argDamageDealt > 0)
            JOptionPane.showMessageDialog(null, this.name + " atingiu seu inimigo e causou " + argDamageDealt + " pontos de dano!");
        else
            JOptionPane.showMessageDialog(null, "O inimigo estava muito longe e não foi atingido...");
        JOptionPane.showMessageDialog(null, this.name + "'s HP: " + this.healthPoints
                + "\t" + this.name + "'s DP: " + this.defensePoints);
        JOptionPane.showMessageDialog(null, enemy.name + "'s HP: " + enemy.healthPoints
                + "\t" + enemy.name + "'s DP: " + enemy.defensePoints);
    }

    protected void attack(Character enemy) {

        int damageDealt = this.attackPoints;

        if(!Game.myBoard.isInRange(this,enemy)) {
            attackBattleLog(enemy, 0);
            //Game.skipTurn();
            }

        else if(enemy.defensePoints >= damageDealt) {
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

    protected void move(Character enemy, int direction) {
        // N -> 0, E-> 1, S-> 2, W-> 3
        if(!Game.myBoard.moveIsValid(this, enemy, direction)) {
            Game.myBoard.movementLog(this,false, "placeholder");
        }
        else{
            String strDirection = switch (direction) {
                case 0 -> {
                    this.position[0]--;
                    yield "cima";
                }
                case 1 -> {
                    this.position[1]++;
                    yield "direita";
                }
                case 2 -> {
                    this.position[0]++;
                    yield "baixo";
                }
                case 3 -> {
                    this.position[1]--;
                    yield "esquerda";
                }
                default -> "placeholder";
            };

            Game.myBoard.movementLog(this,true, strDirection);
        }
    }

    protected void giveName(String name) {
        this.name = name;
    }
    
    protected void ultimate(Character enemy) {
        
    }
}
