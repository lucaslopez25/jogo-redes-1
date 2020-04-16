package server;

import gui.Principal;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import motor.Motor;
import motor.Partida;

public class GameClient {
    private String ipServer;
    private String nome;
    private int portaServer;
    private Motor nucleo;
    
    public GameClient(){
    }

    public void setIpServer(String ipServer) {
        this.ipServer = ipServer;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPortaServer(int portaServer) {
        this.portaServer = portaServer;
    }
    
    public void execute(){
        try {
            Socket socket = new Socket(ipServer,portaServer);//conectar com o servidor
            System.out.println("Cliente conectado");
            
            Receiver receiver = new Receiver(socket.getInputStream(),this);
            new Thread(receiver).start();
            
            //Lê as mensagens do teclado
            Scanner input = new Scanner(System.in);
        
            //Variável que enviará mensagem para o servidor
            PrintStream output = new PrintStream(socket.getOutputStream());
            
            
            while(input.hasNextLine()){
                output.println(input.nextLine());//Enviar mensagem para o servidor
            }
        
            output.close();
            input.close();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void init(){
        this.nucleo = new Motor();
        int qtdPerguntas = 10;
        Partida partida = this.nucleo.criarPartida(qtdPerguntas, this.nome);
        
        Principal janelaJogo = new Principal();
        //janelaJogo.setQuestion(partida.getNextPergunta());
        //List<String> respostas = partida.getRespostas();
        //janelaJogo.setAnswers(respostas);
        janelaJogo.setVisible(true);
    }
}
