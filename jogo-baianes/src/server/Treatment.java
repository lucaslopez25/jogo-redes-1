package server;

import java.io.InputStream;
import java.util.Scanner;

public class Treatment  implements Runnable{
    private String ip;
    private InputStream cliente;
    private Server server;
    private String opponentIp;
    private boolean opponentFound = false;
    
    public Treatment(String ip, InputStream clienteInput, Server server) {
        this.ip=ip;
        this.cliente = clienteInput;
        this.server=server;
    }
    
    public void setOpponent(String ip){
        this.opponentIp = ip;
    }
    
    public void setOpponentFound(boolean status){
        this.opponentFound = status;
        readyToStart();
    }
    
    private void readyToStart(){
        server.sendMessage("OpponentFound");
    }
    @Override
    public void run() {
        //Quando chegar uma mensagem distribui para todos
        Scanner input = new Scanner(this.cliente);
        
        while(input.hasNextLine()){
            server.sendMessage(input.nextLine());
        }
        
        input.close();
    }
    
}
