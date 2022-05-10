package client;

import java.io.IOException;



public class Main{

        public static void main(String[] args) throws IOException {
        	
        	//Creamos objeto Cliente
            Client cli = new Client();
            System.out.println("Cliente se conecta");
            
            //Iniciamos la conexión
            cli.iniciarClient();
        }
}
