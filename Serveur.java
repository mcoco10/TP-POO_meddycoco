import java.io.*;
import java.net.*;
import java.util.Collection;
import java.util.LinkedList;


public class Serveur  {
    
	public static  int i = 0 ;
	
	private static ServerSocket ecoute;
	private static int PORT = 51919;
	//Ports disponibles 49152 jusqu'� 65535

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// On �coute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialis�");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connect�(Serveur) : "+client.getInetAddress().toString());
			
			MonThread  P = new MonThread("Thread"+i,client) ;
			P.start();
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
				System.out.println("Paquet re�u (serveur) :"+O);
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

