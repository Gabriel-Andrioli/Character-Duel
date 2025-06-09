package com.characterduel;

import java.util.Random;

public class Bot extends Character {
    
    Bot(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints, 
            String characterType){
        super(standardAttackPoints, standardDefensePoints, standardAttackRange, standardHealthPoints, characterType);
    }
    
    @Override
    protected String selectAction (Character enemy){
        switch (type) {
            case "Archer" -> {
                if (Game.myBoard.isInRange(this, enemy) && attackPoints>(enemy.defensePoints+enemy.healthPoints)){
                    return "Atacar";
                }
                else if (healthPoints<20 && defensePoints<standardDefensePoints){
                    return "Defender";
                }
                
                else if (Game.myBoard.isInRange(this, enemy)){
                    return "Atacar";
                }
                else{
                    return "Poder Especial";
                }
            }
            case "Mage" -> {
                if (Game.myBoard.isInRange(this, enemy) && attackPoints>(enemy.defensePoints+enemy.healthPoints)){
                    return "Atacar";
                }
                else if((healthPoints+defensePoints)<=enemy.attackPoints){
                    return "Poder Especial";
                }
                else if (healthPoints<20 && defensePoints<standardDefensePoints){
                    return "Defender";
                }
                else if (Game.myBoard.isInRange(this, enemy)){
                    return "Atacar";
                }
                else{
                    return "Mover";
                }
            }
            case "Warrior" -> {
                if (Game.myBoard.isInRange(this, enemy) && attackPoints>(enemy.defensePoints+enemy.healthPoints)){
                    return "Atacar";
                }
                else if (attackPoints<standardAttackPoints*2){
                    return "Poder Especial";
                }
                else if (healthPoints<20 && defensePoints<standardDefensePoints){
                    return "Defender";
                }
                else if (Game.myBoard.isInRange(this, enemy)){
                    return "Atacar";
                }
                else{
                    return "Mover";
                }
            }
        }
        return null;
    }
    
    @Override
    protected int chooseDirection(){
        Random rand = new Random();
        return rand.nextInt(4);
    }
}