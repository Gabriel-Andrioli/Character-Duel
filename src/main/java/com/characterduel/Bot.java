package com.characterduel;

public class Bot extends Character {
    
    Bot(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints, 
            String characterType){
        super(standardAttackPoints, standardDefensePoints, standardAttackRange, standardHealthPoints, characterType);
    }
    
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
                
            }
            case "Warrior" -> {
                
            }
        }
    }
    
    
}
