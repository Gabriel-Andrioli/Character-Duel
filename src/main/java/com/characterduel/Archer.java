package com.characterduel;

import javax.swing.*;

public class Archer extends Bot {

    public Archer() {
        super(8,5,5,100);
    }

    @Override
    protected void ultimate(Character enemy) {
        this.attackRange += standardAttackRange / 5;
        ultimateLog(enemy);
    }

    @Override
    protected void ultimateLog(Character enemy) {
        JOptionPane.showMessageDialog(null, this.name + " aumentou seu alcance de ataque!\n");
        JOptionPane.showMessageDialog(null,
                this.name + "\n"
                        + "Alcance de ataque: " + this.attackRange + "\n");
    }
}
