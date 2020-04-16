/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roselma
 */
public class TesteGUI {

    public static void main(String[] args) {
        List<String> respostas = new ArrayList<String> ();
        Principal janelaJogo = new Principal();
        janelaJogo.setQuestion("alguma pergunta");
        respostas.add("letra a");
        respostas.add("letra b");
        respostas.add("letrac ");
        janelaJogo.setAnswers(respostas);
        janelaJogo.setVisible(true);
    }
    
}
