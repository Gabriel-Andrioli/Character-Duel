package com.characterduel;

import javax.swing.*;
import java.util.Random;

public class Board {
    protected int [][] board = new int[10][10];

    private void setInitialPositions(Character playerOne, Character playerTwo) {
        Random rand = new Random();

        playerOne.getPosition()[0] = rand.nextInt(10);
        playerOne.getPosition()[1] = rand.nextInt(4);
        playerTwo.getPosition()[0] = rand.nextInt(10);
        playerTwo.getPosition()[1] = 9 - rand.nextInt(4);

        board[playerOne.getPosition()[0]][playerOne.getPosition()[1]] = 1;
        board[playerTwo.getPosition()[0]][playerTwo.getPosition()[1]] = 2;
    } 
    
    public void createBoard(Character playerOne, Character playerTwo) {
        setInitialPositions(playerOne, playerTwo);
        JOptionPane.showMessageDialog(null, "O tabuleiro será exposto no console!");
    }

    protected boolean isInRange(Character playerOne, Character playerTwo) {
        int distance = Math.max(Math.abs(playerTwo.getPosition()[0] - playerOne.getPosition()[0]),
                Math.abs(playerTwo.getPosition()[1] - playerOne.getPosition()[1]));
        return distance <= playerOne.getAttackRange();
    }

    protected boolean moveIsValid(Character playerOne, Character playerTwo, int direction) {
        // N -> 0, E-> 1, S-> 2, W-> 3
        if(direction == 0 && playerOne.getPosition()[0] == 0)
            return false;
        if(direction == 1 && playerOne.getPosition()[1] == 9)
            return false;
        if(direction == 2 && playerOne.getPosition()[0] == 9)
            return false;
        if(direction == 3 && playerOne.getPosition()[1] == 0)
            return false;

        if(direction == 0 && playerTwo.getPosition()[1] == playerOne.getPosition()[1] && playerTwo.getPosition()[0] == playerOne.getPosition()[0] - 1)
            return false;
        if(direction == 1 && playerTwo.getPosition()[0] == playerOne.getPosition()[0] && playerTwo.getPosition()[1] == playerOne.getPosition()[1] + 1)
            return false;
        if(direction == 2 && playerTwo.getPosition()[1] == playerOne.getPosition()[1] && playerTwo.getPosition()[0] == playerOne.getPosition()[0] + 1)
            return false;
        if(direction == 3 && playerTwo.getPosition()[0] == playerOne.getPosition()[0] && playerTwo.getPosition()[1] == playerOne.getPosition()[1] - 1)
            return false;
        return true;
    }

    private boolean hasAPlayer(Character player, int x, int y) {
        return player.getPosition()[0] == x && player.getPosition()[1] == y;
    }

    protected void show(Character playerOne, Character playerTwo) {
        System.out.println();
        System.out.println();
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
    }
}