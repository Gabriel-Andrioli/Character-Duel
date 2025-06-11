package com.characterduel;

import javax.swing.JOptionPane;

public class Bot extends Character {
    
    Bot(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints, 
            String characterType){
        super(standardAttackPoints, standardDefensePoints, standardAttackRange, standardHealthPoints, characterType);
    }
    
    @Override
    protected String selectAction (Character enemy){
        switch (this.getType()) {
            case "arqueiro" -> {
                if (Game.myBoard.isInRange(this, enemy) && getAttackPoints() > (enemy.getDefensePoints()+enemy.getHealthPoints())){
                    return "Atacar";
                }
                else if (this.getHealthPoints()<20 && this.getDefensePoints()<this.getStandardDefensePoints()){
                    return "Defender";
                }
                
                else if (Game.myBoard.isInRange(this, enemy)){
                    return "Atacar";
                }
                else{
                    return "Poder Especial";
                }
            }
            case "mago" -> {
                if (Game.myBoard.isInRange(this, enemy) && getAttackPoints() > (enemy.getDefensePoints()+enemy.getHealthPoints())){
                    return "Atacar";
                }
                else if((this.getHealthPoints()+this.getDefensePoints())<=enemy.getAttackPoints()){
                    return "Poder Especial";
                }
                else if (this.getHealthPoints()<20 && this.getDefensePoints()<getStandardDefensePoints()){
                    return "Defender";
                }
                else if (Game.myBoard.isInRange(this, enemy)){
                    return "Atacar";
                }
                else{
                    return "Mover";
                }
            }
            case "guerreiro" -> {
                if (Game.myBoard.isInRange(this, enemy) && getAttackPoints() > (enemy.getDefensePoints()+enemy.getHealthPoints())){
                    return "Atacar";
                }
                else if (getAttackPoints()<getStandardAttackPoints()*2){
                    return "Poder Especial";
                }
                else if (this.getHealthPoints()<20 && this.getDefensePoints()<getStandardDefensePoints()){
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
    protected int chooseDirection(Character enemy){
        if (this.getPosition()[0] > enemy.getPosition()[0]){
            return 0;  //cima
        }
        else if (this.getPosition()[0] < enemy.getPosition()[0]){
            return 2;  //baixo
        }
        else if (this.getPosition()[1] < enemy.getPosition()[1]){
            return 1;  //direita
        }
        else{
            return 3;  //esquerda
        }
    }
    
    protected void showTypeBot(){
        JOptionPane.showMessageDialog(null, "Você batalhará contra " + getName() + ", o " + getType() + ".");
    }
}