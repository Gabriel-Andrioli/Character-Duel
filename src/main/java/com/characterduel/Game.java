package com.characterduel;

import java.util.Random;

public class Game {
    
    public static Board myBoard = new Board();
    
    public static void play() {
        Menu.showInitialMessage();
        do{
            String mode = Menu.chooseMode();
            if (mode.equals("Sair do jogo"))
                endGame();
            else if ("Player x Player".equals(mode)){
                Character PlayerOne = createCharacter(Menu.chooseCharacter(1));
                PlayerOne.giveName(Menu.nameCharacter(1));
                Character PlayerTwo = createCharacter(Menu.chooseCharacter(2));
                PlayerTwo.giveName(Menu.nameCharacter(2));


                myBoard.createBoard(PlayerOne, PlayerTwo);
                myBoard.show(PlayerOne, PlayerTwo);

                while (PlayerOne.isAlive() && PlayerTwo.isAlive()){
                    String action = Menu.chooseAction(PlayerOne.name,1);
                    executeAction(action, PlayerOne, PlayerTwo, 1);
                    myBoard.show(PlayerOne, PlayerTwo);
                    if(!PlayerTwo.isAlive())
                        break;
                    action = Menu.chooseAction(PlayerTwo.name,2);
                    executeAction(action, PlayerTwo, PlayerOne, 2);
                    myBoard.show(PlayerOne, PlayerTwo);
                }
                
                if (!PlayerTwo.isAlive())
                    Menu.winner(PlayerOne.name);
                else
                    Menu.winner(PlayerTwo.name);
            }
            /*else{
                Character PlayerOne = createCharacter(Menu.chooseCharacter(1));
                PlayerOne.giveName(Menu.nameCharacter(1));
                Character botChar = Bot.createBot();

                myBoard.createBoard(PlayerOne, botChar);
                myBoard.show(PlayerOne, botChar);

                while (PlayerOne.isAlive() && botChar.isAlive()){
                    String action = Menu.chooseAction(PlayerOne.name,1);
                    executeAction(action, PlayerOne, Bot, 1);
                    myBoard.show(PlayerOne, Bot);
                    if(!Bot.isAlive())
                        break;
                    action = Bot.action();
                    botExecuteAction();
                    myBoard.show(PlayerOne, Bot);
                }
            }*/
        }while ("Continuar jogando".equals(Menu.continuePlaying()));
    }
    
    private static Character createCharacter (String type){
        Character aux = null;
        switch (type) {
            case "Arqueiro" -> aux = new Archer();
            case "Mago" -> aux = new Mage();
            case "Guerreiro" -> aux = new Warrior();
            case "Sair do jogo" -> endGame();
        }
        return aux;
    }
    
    private static void executeAction (String action, Character player, Character enemy, int n){
        switch (action) {
            case "Mover" -> {
                int direction = Menu.whereToMove(player.name,n);
                if (direction==5)
                    endGame();
                player.move(enemy, direction);
            }
            case "Atacar" -> player.attack(enemy);
            case "Defender" -> player.defend();
            case "Poder Especial" -> player.ultimate(enemy);
            case "Sair do jogo" -> endGame();
        }
    }
    
    private static void endGame (){
        System.exit(0);
    }
}
