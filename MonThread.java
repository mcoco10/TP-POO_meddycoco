
import java.io.*;
import java.net.*;
import java.util.LinkedList;







public class MonThread extends Thread{

	
	private Socket client;

	
	public MonThread(String name,Socket client){
		super(name) ;
		this.client = client ;
		
	}
	
	public void run(){
		 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
		
		 OutputStream out ;
		 ObjectOutputStream objOut ;
		 InputStream in ;
		 ObjectInputStream objIn ;
		 Integer I= new Integer(3);
		 
		 
		 try {
			out = client.getOutputStream();
			objOut = new ObjectOutputStream(out);
			synchronized (this) { 
			objOut.writeObject((Serveur.L).getFirst());
			System.out.println("Paquet envoyé ("+this.getName()+") :"+(Serveur.L).getFirst());
			Serveur.L.remove() ;
		    System.out.println("Liste apres remove : "+Serveur.L);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 try {
			in = client.getInputStream();
			objIn = new ObjectInputStream(in);
			synchronized (this) {  
			Serveur.Ls.add((Object)objIn.readObject());
		    System.out.println("Paquet reçu ("+this.getName()+") :"+Serveur.Ls);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
