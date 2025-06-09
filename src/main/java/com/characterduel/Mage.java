package com.characterduel;

import javax.swing.*;

public class Mage extends Bot {

    public Mage() {
        super(10, 7, 3, 100,"Mage");
    }

    @Override
    protected void ultimate(Character enemy) {
        int aux = this.healthPoints;
        this.healthPoints = enemy.healthPoints;
        enemy.healthPoints = aux;
        ultimateLog(enemy);
    }

    @Override
    protected void ultimateLog(Character enemy) {
        JOptionPane.showMessageDialog(null, this.name + " trocou de vida com seu oponente!\n");
    }
}
