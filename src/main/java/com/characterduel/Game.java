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
                Character playerOne = createCharacter(Menu.chooseCharacter(1));
                playerOne.giveName(Menu.nameCharacter(1));
                Character playerTwo = createCharacter(Menu.chooseCharacter(2));
                playerTwo.giveName(Menu.nameCharacter(2));


                myBoard.createBoard(playerOne, playerTwo);
                myBoard.show(playerOne, playerTwo);

                while (playerOne.isAlive() && playerTwo.isAlive()){
                    String action = Menu.chooseAction(playerOne.name);
                    executeAction(action, playerOne, playerTwo, false);
                    myBoard.show(playerOne, playerTwo);
                    playerOne.statusLog(playerTwo);
                    if(!playerTwo.isAlive())
                        break;
                    action = Menu.chooseAction(playerTwo.name);
                    executeAction(action, playerTwo, playerOne, false);
                    myBoard.show(playerOne, playerTwo);
                    playerTwo.statusLog(playerOne);
                }
                
                if (!playerTwo.isAlive())
                    Menu.winner(playerOne.name);
                else
                    Menu.winner(playerTwo.name);
            }

            else{
                Character playerOne = createCharacter(Menu.chooseCharacter(1));
                playerOne.giveName(Menu.nameCharacter(1));
                Character botChar = createBot();

                myBoard.createBoard(playerOne, botChar);
                myBoard.show(playerOne, botChar);

                while (playerOne.isAlive() && botChar.isAlive()){
                    String action = Menu.chooseAction(playerOne.name);
                    executeAction(action, playerOne, botChar, false);
                    myBoard.show(playerOne, botChar);
                    if(!botChar.isAlive())
                        break;
                    else
                        botChar.statusLog(playerOne);
                    action = botChar.selectAction(playerOne);
                    executeAction(action, botChar, playerOne, true);
                    myBoard.show(playerOne, botChar);
                    if(playerOne.isAlive())
                        playerOne.statusLog(botChar);
                }
                
                if (!botChar.isAlive())
                    Menu.winner(playerOne.name);
                else
                    Menu.winner(botChar.name);
            }
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
    
    private static void executeAction (String action, Character player, Character enemy, boolean botAction){
        switch (action) {
            case "Mover" -> {
                int direction;

                if(botAction)
                    direction = player.chooseDirection(enemy);
                else {
                    direction = Menu.whereToMove(player.name);
                    if (direction == 4)
                        endGame();
                }

                player.move(enemy, direction);
            }
            case "Atacar" -> player.attack(enemy);
            case "Defender" -> player.defend(enemy);
            case "Poder Especial" -> player.ultimate(enemy);
            case "Sair do jogo" -> endGame();
        }
    }
    
    protected static Character createBot (){
        Random rand = new Random();
        int verify = rand.nextInt(3);
        Bot botChar = null;
        switch (verify) {
            case 0 -> {botChar = new Archer();
                botChar.giveName("Oliver Queen");
                botChar.type="arqueiro";
                botChar.showTypeBot();
            }
            case 1 -> {botChar = new Mage();
                botChar.giveName("Trismegisto");
                botChar.type="mago";
                botChar.showTypeBot();
            }
            case 2 -> {botChar = new Warrior();
                botChar.giveName("Lancelot");
                botChar.type="guerreiro";
                botChar.showTypeBot();
            }
        }
        return botChar;
    }
    
    private static void endGame (){
        System.exit(0);
    }
}
