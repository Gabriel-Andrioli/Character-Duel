package com.characterduel;

import javax.swing.JOptionPane;

public class Menu {
    
    private static final String[] gameModes = {"Player x Player", "Contra o computador", "Sair do jogo"};
    private static final String[] characters = {"Arqueiro", "Mago", "Guerreiro", "Sair do jogo"};
    private static final String[] actions = {"Mover", "Atacar", "Defender", "Poder Especial", "Sair do jogo"};
    private static final String[] directions = {"Cima", "Direita", "Baixo", "Esquerda", "Sair do jogo"};
    private static final String[] playAgain = {"Continuar jogando", "Encerrar"};
    
    public static void showInitialMessage(){
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Duelo de Personagens!\n\nDescrição:\n - O jogo consiste em um "
                + "duelo 1v1 entre dois \npersonagens em um tabuleiro 2D. \n - O objetivo é derrotar seu oponente reduzindo "
                + "\ntodos os pontos de vida dele a zero.\n - É importante pensar com sabedoria e ter \numa estratégia "
                + "inteligente. Boa sorte!!\n\nClique em OK para continuar");        
    }
    
    public static String chooseMode(){
        return gameModes[JOptionPane.showOptionDialog(null, "Selecione um modo de jogo:", "Character Duel", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, gameModes, "Contra o computador")];
    }
    
    public static String chooseCharacter(int n){
        return characters[JOptionPane.showOptionDialog(null, "(Jogador "+n+")\nSelecione um personagem:\n1. Arqueiro:\nForça: "
                + "8\nDefesa: 5\nAlcance de Ataque: 5\nPoder Especial: Aumenta seu alcance\n\n2. Mago:\nForça: 10\nDefesa: "
                + "7\nAlcance de Ataque: 3\nPoder Especial: Troca de vida com o oponente\n\n3. Guerreiro:\nForça: 15"
                + "\nDefesa: 10\nAlcance de Ataque: 1\nPoder Especial: Dobra sua força", "Character Duel",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, characters, "Guerreiro")];
    }
    
    public static String nameCharacter(int n){
        return JOptionPane.showInputDialog("(Jogador "+n+")\nDigite o nome do seu personagem:");
    }
    
    public static String chooseAction(String name){
        return actions[JOptionPane.showOptionDialog(null, name + "\nEscolha sua próxima ação:", "Character Duel",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, actions, "Mover")];
    }
    
    public static int whereToMove (String name){
        return JOptionPane.showOptionDialog(null, name + "\nEscolha para onde irá se mover:",
                "Character Duel", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, directions, "Direita");
    }
    
    public static String continuePlaying(){
        return playAgain[JOptionPane.showOptionDialog(null, "Deseja continuar jogando?", "Character Duel", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, playAgain, "Continuar jogando")];
    }
    
    public static void winner(String name){
        JOptionPane.showMessageDialog(null, "Após um forte embate, " + name + " saiu vitorioso!");
    }
}
