package server;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    int port;
    ServerSocket servidor;
    Socket cliente;
    Scanner scanner;
    List<PrintStream> saidasClientes;
    
    public Server(){
        this.port = 22800;
        saidasClientes = new ArrayList<>();
    }
    
    public void execute(){
        String ip;

        try {
            //Abrindo Porta para o Servidor
            servidor = new java.net.ServerSocket(port);
            System.out.println("Porta 22800 aberta!");
            
            while (true) {

                //Aceitando conexão cliente            
                cliente = servidor.accept();
                //ip cliente
                ip = cliente.getInetAddress().getHostAddress();
                //aviso conexão
                System.out.println("Conexão realizada com: " + ip);

                //adicionar saida do cliente a lista de clientes
                PrintStream ps = new PrintStream(cliente.getOutputStream());
                if(saidasClientes.size()<2){
                    saidasClientes.add(ps);
                    //tratamento de clientes em uma nova Thread
                    Treatment tc = new Treatment(ip, cliente.getInputStream(), this);
                    new Thread(tc).start();
                    
                    if(saidasClientes.size()==2){
                        tc.setOpponent(ip);
                        tc.setOpponentFound(true);
                    }
                }else{
                    ps.println("Execesso de jogadores presentes, tente mais tarde!");
                    ps.close();
                    verify();
                }
                

            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    private void verify(){
        for (PrintStream cli : saidasClientes) {
            if(cli.checkError()){
                System.out.println("entrou");
            }
        }
    }
    public void sendMessage(String msg) {

        for (PrintStream cli : saidasClientes) {
            cli.println(msg);
            //System.out.println(msg);
        }
    }

    private void secureClose(final Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

    }

    public void finish() {
        secureClose(servidor);
        secureClose(cliente);
        secureClose(scanner);
        System.exit(2);
    }
    
    public static void main(String[] args){
        Server servidor = new Server();
        servidor.execute();
    }
}
