
import java.io.*;
import java.net.*;







public class MonThread extends Thread{

	
	private static int PORT = 51919;
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
			objOut.writeObject(I);
			System.out.println("Paquet envoyé ("+this.getName()+") :"+I);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 try {
			in = client.getInputStream();
			objIn = new ObjectInputStream(in);
			Integer O = (Integer)objIn.readObject();
			System.out.println("Paquet reçu ("+this.getName()+") :"+O);
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
