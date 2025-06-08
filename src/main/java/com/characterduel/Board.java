package com.characterduel;

import javax.swing.*;
import java.util.Random;

public class Board {
    protected int [][] board = new int[10][10];

    private void setInitialPositions(Character playerOne, Character playerTwo) {
        Random rand = new Random();

        playerOne.position[0] = rand.nextInt(10);
        playerOne.position[1] = rand.nextInt(4);
        playerTwo.position[0] = rand.nextInt(10);
        playerTwo.position[1] = 10 - rand.nextInt(4);

        board[playerOne.position[0]][playerOne.position[1]] = 1;
        board[playerTwo.position[0]][playerTwo.position[1]] = 2;
    } 
    
    public void createBoard(Character playerOne, Character playerTwo) {
        setInitialPositions(playerOne, playerTwo);
        JOptionPane.showMessageDialog(null, "O tabuleiro será exposto no console!");
    }

    protected boolean isInRange(Character playerOne, Character playerTwo) {
        int distance = Math.max(Math.abs(playerTwo.position[0] - playerOne.position[0]),
                Math.abs(playerTwo.position[1] - playerOne.position[1]));
        return distance <= playerOne.attackRange;
    }

    protected boolean moveIsValid(Character playerOne, Character playerTwo, int direction) {
        // N -> 0, E-> 1, S-> 2, W-> 3
        if(direction == 0 && playerOne.position[0] == 0)
            return false;
        if(direction == 1 && playerOne.position[1] == 9)
            return false;
        if(direction == 2 && playerOne.position[0] == 9)
            return false;
        if(direction == 3 && playerOne.position[1] == 0)
            return false;

        if(direction == 0 && playerTwo.position[1] == playerOne.position[1] && playerTwo.position[0] == playerOne.position[0] - 1)
            return false;
        if(direction == 1 && playerTwo.position[0] == playerOne.position[0] && playerTwo.position[1] == playerOne.position[1] + 1)
            return false;
        if(direction == 2 && playerTwo.position[1] == playerOne.position[1] && playerTwo.position[0] == playerOne.position[0] + 1)
            return false;
        if(direction == 3 && playerTwo.position[0] == playerOne.position[0] && playerTwo.position[1] == playerOne.position[1] - 1)
            return false;
        return true;
    }

    protected void movementLog(Character player, boolean success, String stringDirection) {
        if(success) 
            JOptionPane.showMessageDialog(null, player.name + " moveu " + stringDirection + "!");
        else
            JOptionPane.showMessageDialog(null, "Movimento inválido!");
    }

    private boolean hasAPlayer(Character player, int x, int y) {
        return player.position[0] == x && player.position[1] == y;
    }

    protected void show(Character playerOne, Character playerTwo) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(!hasAPlayer(playerOne, i, j) && !hasAPlayer(playerTwo, i, j))
                    System.out.print(" ( ) ");
                else if(hasAPlayer(playerOne, i, j))
                    System.out.print(" (1) ");
                else
                    System.out.print(" (2) ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}