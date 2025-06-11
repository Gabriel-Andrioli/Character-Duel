package com.characterduel;

import javax.swing.JOptionPane;

public class Character {
    private String name;

    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private int attackRange;

    private final int standardDefensePoints;
    private final int standardAttackPoints;
    private final int standardAttackRange;

    private int [] position = new int [2];
    private String type;

    public Character(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints, 
            String characterType) {
        healthPoints = standardHealthPoints;
        this.standardAttackPoints = attackPoints = standardAttackPoints;
        this.standardDefensePoints = defensePoints = standardDefensePoints;
        this.standardAttackRange = attackRange = standardAttackRange;
        this.type = characterType;
    }

    protected int getHealthPoints() {
        return healthPoints;
    }

    protected int getStandardDefensePoints() {
        return standardDefensePoints;
    }

    protected int getStandardAttackPoints() {
        return standardAttackPoints;
    }

    protected int getStandardAttackRange() {
        return standardAttackRange;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected int getDefensePoints() {
        return defensePoints;
    }

    protected String getType() {
        return type;
    }

    protected void setType(String characterType) {
        this.type = characterType;
    }

    protected String getName() {
        return name;
    }

    protected int getAttackPoints() {
        return this.attackPoints;
    }

    protected void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected int [] getPosition() {
        return position;
    }

    protected int getAttackRange() {
        return this.attackRange;
    }

    protected void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    private void attackLog(Character enemy, int argDamageDealt, boolean shieldIsBroken) {
        if(argDamageDealt > 0 && shieldIsBroken)
            JOptionPane.showMessageDialog(null, this.name + " quebrou a armadura de " + enemy.name + ", além de lhe causar " + argDamageDealt +
                    " pontos de dano!");
        else if(shieldIsBroken)
            JOptionPane.showMessageDialog(null, this.name + " quebrou a armadura de " + enemy.name + "!");
        else if(argDamageDealt > 0)
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
            attackLog(enemy, 0,false);
            }

        else if(enemy.defensePoints > damageDealt) {
            enemy.defensePoints -= damageDealt;
            attackLog(enemy, damageDealt,false);
        }

        else if (enemy.defensePoints > 0) {
            damageDealt -= enemy.defensePoints;
            enemy.defensePoints = 0;
            enemy.healthPoints -= damageDealt;
            attackLog(enemy,damageDealt,true);
        }

        else {
            enemy.healthPoints -= damageDealt;
            attackLog(enemy,damageDealt,false);
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

    protected void ultimate(Character enemy) {

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
