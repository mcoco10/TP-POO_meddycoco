import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;


public class Serveur  {
    
	public static  int i = 0 ;
	public static Point p1 = new Point(1,2,"a") ;
	public static Point p2 = new Point(3,4,"b") ;
	public static Point p3 = new Point(5,6,"c") ;
	
	
	public static ArrayList<MonThread> Ps = new ArrayList<MonThread>() ;
	
	//Liste d'Objet Quelconque
	public static LinkedList<Object> L = new LinkedList<Object>();
	
	//Liste des  attributs des Objets
	public static LinkedList<Object> Ls = new LinkedList<Object>();
	
	private static ServerSocket ecoute;
	private static int PORT = 51919;
	//Ports disponibles 49152 jusqu'à 65535
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			L.add(p1);
			L.add(p2);
			L.add(p3);
			System.out.println(""+ p1.x);
			System.out.println("Liste : "+ L);
			
			// On écoute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialisé");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connecté(Serveur) : "+client.getInetAddress().toString());
			
			
			
			
			
			MonThread  P = new MonThread("Thread"+i,client) ;
			P.start();
			Ps.add(P);
			i++;
			
			
			
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }


	}

}

