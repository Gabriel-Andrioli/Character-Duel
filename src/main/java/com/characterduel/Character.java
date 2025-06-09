package com.characterduel;

import javax.swing.JOptionPane;

public class Character {
    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    protected int attackRange;

    protected int standardDefensePoints;
    protected int standardHealthPoints;
    protected int standardAttackPoints;
    protected int standardAttackRange;

    protected int [] position = new int [2];
    protected String type;

    public Character(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints, 
            String characterType) {
        this.standardHealthPoints = healthPoints = standardHealthPoints;
        this.standardAttackPoints = attackPoints = standardAttackPoints;
        this.standardDefensePoints = defensePoints = standardDefensePoints;
        this.standardAttackRange = attackRange = standardAttackRange;
        this.type=characterType;
    }

    private void attackLog(Character enemy, int argDamageDealt) {
        if(argDamageDealt > 0)
            JOptionPane.showMessageDialog(null, this.name + " atingiu seu inimigo e causou " + argDamageDealt + " pontos de dano!");
        else
            JOptionPane.showMessageDialog(null, "O inimigo estava muito longe e não foi atingido...");
    }

    private void movementLog(Character player, boolean success, String stringDirection) {
        if(success)
            JOptionPane.showMessageDialog(null, player.name + " moveu para " + stringDirection + "!");
        else
            JOptionPane.showMessageDialog(null, "Movimento inválido!");
    }

    private void defendLog() {
        if(defensePoints == standardDefensePoints)
            JOptionPane.showMessageDialog(null, "A armadura de " + this.name + " já estava em perfeito estado...");
        else
            JOptionPane.showMessageDialog(null, this.name + " se defendeu e recuperou " + 
                    (standardDefensePoints - defensePoints) + " pontos de escudo!");
    }

     protected void ultimateLog(Character enemy) {

     }

    protected void attack(Character enemy) {

        int damageDealt = this.attackPoints;

        if(!Game.myBoard.isInRange(this,enemy)) {
            attackLog(enemy, 0);
            }

        else if(enemy.defensePoints >= damageDealt) {
            enemy.defensePoints -= damageDealt;
            attackLog(enemy, damageDealt);
        }

        else if (enemy.defensePoints > 0) {
            damageDealt -= enemy.defensePoints;
            enemy.defensePoints = 0;
            enemy.healthPoints -= damageDealt;
            attackLog(enemy, damageDealt);
        }

        else {
            enemy.healthPoints -= damageDealt;
            attackLog(enemy, damageDealt);
        }
    }

    protected void defend(Character enemy) {
        defendLog();
        this.defensePoints = this.standardDefensePoints;
    }

    protected boolean isAlive() {
        return this.healthPoints > 0;
    }

    protected void move(Character enemy, int direction) {
        // N -> 0, E-> 1, S-> 2, W-> 3
        if(!Game.myBoard.moveIsValid(this, enemy, direction)) {
            movementLog(this,false, "placeholder");
            return;
        }
        
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

        movementLog(this,true,strDirection);
    }
    
    protected void statusLog(Character enemy){
        JOptionPane.showMessageDialog(null,
                this.name + "\n"
                        + "PV: " + this.healthPoints + "\n"
                        + "PE: " + this.defensePoints + "\n\n"
                        + enemy.name + "\n"
                        + "PV: " + enemy.healthPoints + "\n"
                        + "PE: " + enemy.defensePoints + "\n");
    }

    protected void giveName(String name) {
        this.name = name;
    }
    
    protected void ultimate(Character enemy) {
        
    }
    
    protected Character createBot(){
        return null;
    }
    
    protected String selectAction(Character enemy){
        return null;
    }
    
    protected int chooseDirection(Character enemy){
        return 0;
    }
}
