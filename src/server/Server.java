package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	//Especificamos el puerto
    private final int PUERTO = 9876; 
    private ServerSocket serverSocket;
    private Socket socket;
    
    //Definimos el constructor
    public Server() throws IOException {
        serverSocket = new ServerSocket(PUERTO); //Definimos la conexion
        socket = new Socket(); //Iniciamos el cliente
    }
    
 
    public void iniciarServer() throws IOException {
    	//Sacamos por consola mensaje de espera
    	System.out.println("Esperando la conexion del cliente");
    	socket = serverSocket.accept();
    	//Pedir nombre cliente
    	System.out.println("Nombre del cliente");
    	DataInputStream entrada = new DataInputStream(socket.getInputStream());
    	//Leemos la respuesta del cliente y
    	//Declaramos la variable nom_client
    	String nom_client = entrada.readUTF();
    	DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
    	//Mostrar nombre del cliente
    	System.out.println("El nombre del cliente que se ha conectado es: " + nom_client);
    	//Preguntamos el numero de tareas
    	System.out.println("Cuanta tareas tienes que realizar?");
    	//Declaramos la variable tarea
    	int tarea = entrada.readInt();
    	//Mostramos respuesta del cliente
    	System.out.println("El numero de tarea a realizar son: " + tarea);
    	
    	//Arraylist para el numero de tareas
    	ArrayList<Tarea> list_tarea = new ArrayList<Tarea>();
    	
    	for(int i = 0; i<tarea; i++) {
    		
    		salida.writeUTF("La tarea numero: " + (i+1));
  
    		
    		salida.writeUTF("Dime la descripcion de la tarea");
    		String descripcion = (entrada.readUTF());
    		
    		salida.writeUTF("Dime el estado de la tarea");
    		String estado = entrada.readUTF();
    		
    		
    		list_tarea.add(new Tarea(descripcion, estado));
    	}
    	
    	System.out.println("Las tareas que tienes que realizar son: " + list_tarea);
    	salida.writeUTF("Sus tareas son: " + list_tarea);
    	socket.close();
    	entrada.close();
    	salida.close();
    	
    	
    }
    //Cerramos el servidor
    	public void finalizarServer() throws IOException {
            serverSocket.close();
            System.out.println("Fin del programa");
            
    	}
    
}