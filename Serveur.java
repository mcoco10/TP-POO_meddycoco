import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class Serveur  {
    
	public static  int i = 0 ;
	public static int j=0;
	public static ArrayList<MonThread> Ps = new ArrayList<MonThread>() ;
	public static LinkedList<Object> L = new LinkedList<Object>();
	public static LinkedList<Object> Ls = new LinkedList<Object>();
	private static ServerSocket ecoute;
	private static int PORT = 51919;
	//Ports disponibles 49152 jusqu'à 65535
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(j=0;j<5;j++)
		{
			L.add(j);
		}
		
		try {
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
			
			/*
			
			
			OutputStream out = client.getOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			
			InputStream in = client.getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			Integer I= new Integer(3);
			objOut.writeObject(I);
			
			try {
				Integer O = (Integer)objIn.readObject();
				System.out.println("Paquet reçu (serveur) :"+O);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			client.close();*/
			
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }


	}

}

