package com.characterduel;

import javax.swing.*;

public class Archer extends Bot {

    public Archer() {
        super(8,5,5,100,"arqueiro");
    }

    @Override
    protected void ultimate(Character enemy) {
        this.setAttackRange(getStandardAttackRange());
        ultimateLog(enemy);
    }

    @Override
    protected void ultimateLog(Character enemy) {
        JOptionPane.showMessageDialog(null, this.getName() + " aumentou seu alcance de ataque!\n");
        JOptionPane.showMessageDialog(null,
                this.getName() + "\n"
                        + "Alcance de ataque: " + this.getAttackRange() + "\n");
    }
}
