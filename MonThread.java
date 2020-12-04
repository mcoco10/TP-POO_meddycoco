
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;







public class MonThread extends Thread{

	
	private Socket client;
	Scanner sc = new Scanner(System.in);
	char C[] ;
	Object str ;
	
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
		 
		 /*
		 System.out.println("Saisissez une Objet dans la liste a envoyé :");
		 str = sc.nextLine();
		 for(int x=0;x<str.length();x++){
		     C[x] = str.charAt(x);
		 }
		 System.out.println("Vous avez saisi  : " + str);
		 
		 Serveur.L.add(str);
		 */
		 
		 Random rand = new Random(); 
	     
		 synchronized (this) { 
			 
		     try {
			    out = client.getOutputStream();
			    objOut = new ObjectOutputStream(out);
			    //objOut.writeObject(Serveur.L.get(rand.nextInt(Serveur.L.size())));
			    objOut.writeObject((Serveur.L).getFirst());
			    System.out.println("Paquet envoyé ("+this.getName()+") :"+(Serveur.L).getFirst());
			    Serveur.L.remove() ;
			    System.out.println("Liste apres remove : "+Serveur.L);
		    } catch (IOException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
		    }
		
		 }
		
		 
		 synchronized (this) { 
			 
			 
		     try {
			    in = client.getInputStream();
			    objIn = new ObjectInputStream(in);
			    //Integer O = (Integer)objIn.readObject();
			    Serveur.Ls.add((Object)objIn.readObject());
			    System.out.println("Paquet reçu ("+this.getName()+") :"+Serveur.Ls);
		    } catch (IOException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
		    } catch (ClassNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		    }
		
		 
		 }
	
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
