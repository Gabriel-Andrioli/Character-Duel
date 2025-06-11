package com.characterduel;

import javax.swing.*;

public class Warrior extends Bot {

    public Warrior() {
        super(15,10,1,100,"guerreiro");
    }

    @Override
    protected void ultimate(Character enemy) {
        ultimateLog(enemy);
        this.setAttackPoints(this.getStandardAttackPoints()*2);
    }

    @Override
    protected void ultimateLog(Character enemy) {
        if(this.getAttackPoints() > this.getStandardAttackPoints())
            JOptionPane.showMessageDialog(null, this.getName() + " já está enfurecido...");
        else {
            JOptionPane.showMessageDialog(null, this.getName() + " está enfurecido e duplicou sua força!\n");
            JOptionPane.showMessageDialog(null,
                    this.getName() + "\n"
                            + "Força: " + this.getStandardAttackPoints()*2 + "\n");
        }
    }
}
