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
                    String action = Menu.chooseAction(PlayerOne.name);
                    executeAction(action, PlayerOne, PlayerTwo, Menu.whereToMove(PlayerOne.name));
                    myBoard.show(PlayerOne, PlayerTwo);
                    PlayerOne.statusLog(PlayerTwo);
                    if(!PlayerTwo.isAlive())
                        break;
                    action = Menu.chooseAction(PlayerTwo.name);
                    executeAction(action, PlayerTwo, PlayerOne, Menu.whereToMove(PlayerTwo.name));
                    myBoard.show(PlayerOne, PlayerTwo);
                    PlayerTwo.statusLog(PlayerOne);
                }
                
                if (!PlayerTwo.isAlive())
                    Menu.winner(PlayerOne.name);
                else
                    Menu.winner(PlayerTwo.name);
            }

            else{
                Character PlayerOne = createCharacter(Menu.chooseCharacter(1));
                PlayerOne.giveName(Menu.nameCharacter(1));
                Character botChar = createBot();

                myBoard.createBoard(PlayerOne, botChar);
                myBoard.show(PlayerOne, botChar);

                while (PlayerOne.isAlive() && botChar.isAlive()){
                    String action = Menu.chooseAction(PlayerOne.name);
                    executeAction(action, PlayerOne, botChar, 10);  //10=flag
                    myBoard.show(PlayerOne, botChar);
                    if(!botChar.isAlive())
                        break;
                    else
                        botChar.statusLog(PlayerOne);
                    action = botChar.selectAction(PlayerOne);
                    executeAction(action, botChar, PlayerOne, botChar.chooseDirection(PlayerOne));
                    myBoard.show(PlayerOne, botChar);
                    if(PlayerOne.isAlive())
                        PlayerOne.statusLog(botChar);
                }
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
    
    private static void executeAction (String action, Character player, Character enemy, int direction){
        switch (action) {
            case "Mover" -> {
                if (direction==4)
                    endGame();
                if (direction==10)
                    direction=Menu.whereToMove(player.name);
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
