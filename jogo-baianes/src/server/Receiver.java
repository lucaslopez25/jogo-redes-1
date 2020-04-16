package server;

import java.io.InputStream;
import java.util.Scanner;

public class Receiver implements Runnable{
    private InputStream servidor;
    private GameClient cliente;
    
    public Receiver(InputStream servidor, GameClient cliente){
        this.servidor = servidor;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        // Recebe mensagens do servidor e imprime na tela
        Scanner input = new Scanner(this.servidor);
        
        while(input.hasNext()){
            String msg = input.nextLine();
            String opponentFound = "OpponentFound";
            if(msg.equalsIgnoreCase(opponentFound)){
                this.cliente.init();
            }else{
                System.out.println(msg);
            }
        }
    }
    
    
}
