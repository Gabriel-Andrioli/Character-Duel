package com.characterduel;

import javax.swing.*;

public class Mage extends Bot {

    public Mage() {
        super(10, 7, 3, 100,"mago");
    }

    @Override
    protected void ultimate(Character enemy) {
        int aux = this.getHealthPoints();
        this.setHealthPoints(enemy.getHealthPoints());
        enemy.setHealthPoints(aux);
        ultimateLog(enemy);
    }

    @Override
    protected void ultimateLog(Character enemy) {
        JOptionPane.showMessageDialog(null, this.getName() + " trocou de vida com seu oponente!\n");
    }
}
