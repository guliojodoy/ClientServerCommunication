package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	//Añadimos el host
    private final String HOST = "localhost";
    //Añadimos el puerto
    private final int PUERTO = 9876;
    private Socket socket;
    //Declaramos la variable Scanner
    Scanner sc = new Scanner(System.in);

    public Client() throws IOException {
        socket = new Socket(HOST, PUERTO);
    }

    public void iniciarClient() throws IOException {
    	
    	DataInputStream entrada = new DataInputStream(socket.getInputStream());
    	System.out.println(entrada);
    	DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
    	System.out.println("Escribe tu nombre");
    	//Ponemos el nombre
    	String nombre = sc.next();
    	//Mensaje por pantalla desde el servidor
    	salida.writeUTF(nombre);
    	System.out.println("Escribe el numero de tareas que tienes que realizar");
    	//Añadir numero de tareas entrada al bucle
    	int tarea = sc.nextInt();
    	salida.writeInt(tarea);
    	for (int i = 0; i<tarea;i++) {
    		
    		System.out.println(entrada.readUTF());
 
    		//Descripcion
    		System.out.println(entrada.readUTF());
    		String descripcion = sc.next();
    		salida.writeUTF(descripcion);
    		//Entradas
    		System.out.println(entrada.readUTF());
    		String estado = sc.next();
    		salida.writeUTF(estado);
    		    	
    	}
		System.out.println(entrada.readUTF()); //Salida de mensaje desde el servidor

    	salida.close();
    	entrada.close();
    	socket.close();
    }
}
