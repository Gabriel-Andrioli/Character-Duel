package com.characterduel;

import java.util.Random;

public class Board {
    private int [][] board = new int[10][10];
    private int [] playerOnePosition = new int [2];
    private int [] playerTwoPosition = new int [2];

    private void setInitialPositions() {
        Random rand = new Random();
        playerOnePosition[0] = rand.nextInt(10);
        playerTwoPosition[1] = rand.nextInt(4);
        playerOnePosition[0] = rand.nextInt(10);
        playerTwoPosition[1] = 10 - rand.nextInt(4);
    }

    public Board() {
        setInitialPositions();
    }

    protected static boolean isInRange(Character playerOne, Character playerTwo) {
        int distance = Math.max(Math.abs(playerTwo.position[0] - playerOne.position[0]),
                Math.abs(playerTwo.position[1] - playerOne.position[1]));
        return distance <= playerOne.attackRange;
    }
}
