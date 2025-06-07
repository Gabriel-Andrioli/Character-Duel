<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.characterduel;

/**
 *
 * @author Frederico Amaral
 */
public class Menu {
    
}
=======
package com.characterduel;

import javax.swing.JOptionPane;

public class Menu {
    
    private final String[] gameModes = {"Player x Player", "Contra o computador", "Sair do jogo"};
    private final String[] characters = {"Arqueiro", "Mago", "Guerreiro", "Sair do jogo"};
    private final String[] actions = {"Mover", "Atacar", "Defender", "Poder Especial", "Sair do jogo"};
    private final String[] directions = {"Cima", "Esquerda", "Direita", "Baixo", "Sair do jogo"};

    
    public Menu(){
        
    }
    
    public void showInitialMessage(){
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Duelo de Personagens!\n\nDescrição:\n - O jogo consiste em um "
                + "duelo 1v1 entre dois \npersonagens em um tabuleiro 2D. \n - O objetivo é derrotar seu oponente reduzindo "
                + "\ntodos os pontos de vida dele a zero.\n - É importante pensar com sabedoria e ter \numa estratégia "
                + "inteligente. Boa sorte!!\n\nClique em OK para continuar");        
    }
    
    public String chooseMode(){
        return gameModes[JOptionPane.showOptionDialog(null, "Selecione um modo de jogo:", "Character Duel", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, gameModes, "Contra o computador")];
    }
    
    public String chooseCharacter(int n){
        return characters[JOptionPane.showOptionDialog(null, "(Player "+n+")\nSelecione um personagem:\n1. Arqueiro:\nForça: "
                + "+\nDefesa: +\nAlcance de Ataque: +++\nPoder Especial: Aumenta seu alcance\n\n2. Mago:\nForça: ++\nDefesa: "
                + "++\nAlcance de Ataque: ++\nPoder Especial: Troca de vida com o oponente\n\n3. Guerreiro:\nForça: +++"
                + "\nDefesa: +++\nAlcance de Ataque: +\nPoder Especial: Dobra sua força", "Character Duel", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, characters, "Guerreiro")];
    }
    
    public String nameCharacter(int n){
        return JOptionPane.showInputDialog("(Player "+n+")\nDigite o nome do seu personagem:");
    }
    
    public String chooseAction(int n){
        return actions[JOptionPane.showOptionDialog(null, "(Player "+n+")\nEscolha sua próxima ação:", "Character Duel", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, actions, "Mover")];
    }
    
    public String whereToMove (int n){
        return directions[JOptionPane.showOptionDialog(null, "(Player "+n+")\nEscolha para onde irá se mover:", 
                "Character Duel", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, directions, "Direita")];
    }
    /*   PARA TESTES, USAR NA MAIN:
    Menu menu = new Menu();
    menu.showInitialMessage();
    menu.chooseMode();
    menu.chooseCharacter(1);
    menu.nameCharacter(1);
    menu.chooseAction(1);
    menu.whereToMove(1);
*/
}
    
>>>>>>> Stashed changes
