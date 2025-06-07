package com.characterduel;

public class Game {
    public static void play() {
        Menu.showInitialMessage();
        
        String mode = Menu.chooseMode();
        if ("Player x Player".equals(mode)){
            String characterTypeP1 = Menu.chooseCharacter(1);
            String nameP1 = Menu.nameCharacter(1);
            String characterTypeP2 = Menu.chooseCharacter(2);
            String nameP2 = Menu.nameCharacter(2);
            Character PlayerOne = createCharacter(characterTypeP1);
            Character PlayerTwo = createCharacter(characterTypeP2);
            
            Board myBoard = new Board(PlayerOne, PlayerTwo);
            Board.show(PlayerOne, PlayerTwo);
            
            while (PlayerOne.isAlive() && PlayerTwo.isAlive()){
                
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
            case "Mover" -> player.move(player, Menu.whereToMove(n));
            case "Atacar" -> player.attack(enemy);
            case "Defender" -> player.defend();
            case "Poder especial" -> player.ultimate(enemy);
            case "Sair do jogo" -> endGame();
        }
    }
    
    private static void endGame (){
        
    }
}
