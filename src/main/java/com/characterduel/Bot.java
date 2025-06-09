package com.characterduel;

import java.util.Random;

public class Bot extends Character {
    
    Bot(int standardAttackPoints, int standardDefensePoints, int standardAttackRange, int standardHealthPoints){
        super(standardAttackPoints, standardDefensePoints, standardAttackRange, standardHealthPoints);
    }
        
    @Override
    protected Character createBot (){
        Random rand = new Random();
        int verify = rand.nextInt(3);
        Character botChar = null;
        switch (verify) {
            case 0 -> {botChar = new Archer();
                botChar.giveName("Flechas");
            }
            case 1 -> {botChar = new Mage();
                botChar.giveName("El Mago");
            }
            case 2 -> {botChar = new Warrior();
                botChar.giveName("Cavaleiro");
            }
        }
        return botChar;
    }
    
}
