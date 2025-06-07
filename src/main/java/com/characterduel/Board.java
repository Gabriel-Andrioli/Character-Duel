package com.characterduel;

import java.util.Random;

public class Board {
    private int [][] board = new int[10][10];

    private void setInitialPositions(Character playerOne, Character playerTwo) {
        Random rand = new Random();

        playerOne.position[0] = rand.nextInt(10);
        playerOne.position[1] = rand.nextInt(4);
        playerTwo.position[0] = rand.nextInt(10);
        playerTwo.position[1] = 10 - rand.nextInt(4);

        board[playerOne.position[0]][playerOne.position[1]] = 1;
        board[playerTwo.position[0]][playerTwo.position[1]] = 2;
    }

    public Board(Character playerOne, Character playerTwo) {
        setInitialPositions(playerOne, playerTwo);
    }

    protected static boolean isInRange(Character playerOne, Character playerTwo) {
        int distance = Math.max(Math.abs(playerTwo.position[0] - playerOne.position[0]),
                Math.abs(playerTwo.position[1] - playerOne.position[1]));
        return distance <= playerOne.attackRange;
    }

    protected static boolean moveIsValid(int [] position, int direction) {
        // N -> 1, E-> 2, S-> 3, W-> 4
        if(direction == 1 && position[1] == 9)
            return false;
        if(direction == 2 && position[0] == 9)
            return false;
        if(direction == 3 && position[1] == 0)
            return false;
        if(direction == 4 && position[0] == 0)
            return false;
        return true;
    }

    protected static void movementLog(boolean sucess) {
        
    }
}
