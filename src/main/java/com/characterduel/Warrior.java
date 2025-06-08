package com.characterduel;

import javax.swing.*;

public class Warrior extends Character {

    public Warrior() {
        super(15,10,1,100);
    }

    @Override
    protected void ultimate(Character enemy) {
        ultimateLog(enemy);
        this.attackPoints = this.standardAttackPoints*2;
    }

    @Override
    protected void ultimateLog(Character enemy) {
        if(this.attackPoints > this.standardAttackPoints)
            JOptionPane.showMessageDialog(null, this.name + " já está enfurecido!");
        else {
            JOptionPane.showMessageDialog(null, this.name + " está enfurecido e duplicou sua força!\n");
            JOptionPane.showMessageDialog(null,
                    this.name + "\n"
                            + "Força: " + this.attackPoints + "\n");
        }
    }
}
