/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import motor.Pergunta;

/**
 *
 * @author PICHAU
 */
public class Game{
        private boolean next = false;
        private Thread t = null;
        private Jogo jogo = null;
        
        public Game(Jogo jogo) {
            this.jogo=jogo;
            t = new Thread(new GamesRun());
            t.setDaemon(true);
            t.start();
        }
        private synchronized void verificaPausa() throws InterruptedException{
            //se a variavel next valer true, indica que a thread deve dormir
            while (next) {
                wait();
            }
        }
        public synchronized void setPausado(boolean status) {
            this.next = status;
            if (!this.next)
               notify();
        }
        private void atualiza(){
            Pergunta pergunta = jogo.getNext();
            if(pergunta!=null){
                jogo.setPerguntaCopy(pergunta);
                jogo.setLabelPergunta(pergunta.getPergunta());
                List<String> resp = pergunta.getRespostas();
                Enumeration<AbstractButton> lista = jogo.getButtonElements();
                if(!resp.isEmpty()){
                    int ponteiro = 0;
                    while(lista.hasMoreElements()){
                        AbstractButton botao = lista.nextElement();
                        botao.setText(resp.get(ponteiro));
                        ponteiro++;
                    }
                }
            }else{
                jogo.finalizarPartida();
                jogo.comunicate("partidaEnd");
            }
            this.next=true;
        }
        private void verificarGanhador(){
            //if(partida.isPartidaFinalizada() && partida.isOpponentEnded()){
                
            //}
        }
        protected void finish(){
            t.interrupt();
        }
        private class GamesRun implements Runnable{
            public void run(){
                try {
                    while (true) {                                
                        verificaPausa();
                        atualiza();       
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Oops! Ocorreu um erro inesperado. \nPor favor, reinicie o jogo.");
                }
            }
        }
    }
