import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;


public class Serveur  {
    
	public static  int i = 0 ;
	static int tableauEntier[] = {0,1,2,3,4,5,6,7,8,9};
	static double tableauDouble[] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
	static char tableauCaractere[] = {'a','b','c','d','e','f','g'};
	static String tableauChaine[] = {"chaine1", "chaine2", "chaine3" , "chaine4"};
	
	static Random rand = new Random() ;
	static int choix1 = tableauEntier[ rand.nextInt(tableauEntier.length)] ;
	static double choix2 = tableauDouble[ rand.nextInt(tableauDouble.length)] ;
	static char choix3 = tableauCaractere[ rand.nextInt(tableauCaractere.length)] ;
	static String choix4 = tableauChaine[ rand.nextInt(tableauChaine.length)] ;
	
	
	
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
		/*
		System.out.println("choix1 : "+choix1);
		System.out.println("choix2 : "+choix2);
		System.out.println("choix3 : "+choix3);
		System.out.println("choix4 : "+choix4);
		*/
		
		try {
			
			L.add(choix1);
			L.add(choix2);
			L.add(choix3);
			L.add(choix4);
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

