package server;

import java.io.IOException;



public class Main {

    public static void main(String[] args) throws IOException {
        //Definimos objeto
    	Server serv = new Server();
        System.out.println("Inicia Servidor");
        
        //Iniciamos el servidor
        serv.iniciarServer();
        
        //finalizamos el servidor
        serv.finalizarServer();
    }
}
