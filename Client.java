import java.io.*;
import java.net.*;

public class Client {

	static boolean n = true;
	private static String serverhost = "localhost";
	private static int PORT = 51919;
	public static int i ;
	//Ports disponibles 49152 jusqu'� 65535
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket s=null;
		 try {
			 
			 
				
			     System.out.println("Connexion...");
			     s=new Socket(serverhost,PORT); 
			     // Cr�ation du socket
			     System.out.println("Connect�.");
		         // R�cup�ration des flux d�entr�e/sortie
			     
			     OutputStream out = s.getOutputStream();
			     ObjectOutputStream objOut = new ObjectOutputStream(out);
			     
			     InputStream in = s.getInputStream();
			     ObjectInputStream objIn = new ObjectInputStream(in);
			     
			     Integer O= new Integer(5) ;
			     objOut.writeObject(O);
			     System.out.println("Paquet envoy� (client"+i+") :"+O);
			     
			     try {
					Integer I= (Integer)objIn.readObject();
					System.out.println("Paquet re�u (client"+i+""
							+ ") :"+I);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     i++;
				
		        s.close();
				
		} 
		 catch (IOException e) {System.err.println(e);}


	}

}

