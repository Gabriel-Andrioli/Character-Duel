package com.characterduel;

public class Game {
    public Board myBoard = null;
    
    public static void play() {
        Menu.showInitialMessage();
        
        String mode = Menu.chooseMode();
        if (mode.equals("Sair do jogo"))
            endGame();
        else if ("Player x Player".equals(mode)){
            Character PlayerOne = createCharacter(Menu.chooseCharacter(1));
            PlayerOne.giveName(Menu.nameCharacter(1));
            Character PlayerTwo = createCharacter(Menu.chooseCharacter(2));
            PlayerTwo.giveName(Menu.nameCharacter(2));
            myBoard
            
            myBoard = new Board(PlayerOne, PlayerTwo);
            myBoard.show(PlayerOne, PlayerTwo);
            
            while (PlayerOne.isAlive() && PlayerTwo.isAlive()){
                executeAction(Menu.chooseAction(1), PlayerOne, PlayerTwo, 1);
                myBoard.show(PlayerOne, PlayerTwo);
                executeAction(Menu.chooseAction(2), PlayerTwo, PlayerOne, 2);
                myBoard.show(PlayerOne, PlayerTwo);
            }
        }
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
            case "Mover" -> {int direction = Menu.whereToMove(n);
                if (direction==5)
                    endGame();
                player.move(player, direction);
            }
            case "Atacar" -> player.attack(enemy);
            case "Defender" -> player.defend();
            case "Poder especial" -> player.ultimate(enemy);
            case "Sair do jogo" -> endGame();
        }
    }
    
    private static void endGame (){
        System.exit(0);
    }
}
