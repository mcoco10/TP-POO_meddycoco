import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	
	
	private static String serverhost = "localhost";
	private static int PORT = 51919;
	//Ports disponibles 49152 jusqu'à 65535
	
	public static int i ;
	public static int n ;
	
	static Scanner sct = new Scanner(System.in);
	static Object strg ;
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket s=null;
		 try {
			 
			 
			
			 ArrayList<Object> La = new ArrayList<Object>() ;
			 ArrayList<Object> Attrs = new ArrayList<Object>() ;
			 
			 
			     System.out.println("Connexion...");
			     s=new Socket(serverhost,PORT); 
			     // Création du socket
			     System.out.println("Connecté.");
		         // Récupération des flux d’entrée/sortie
			     
			     OutputStream out = s.getOutputStream();
			     ObjectOutputStream objOut = new ObjectOutputStream(out);
			     
			     InputStream in = s.getInputStream();
			     ObjectInputStream objIn = new ObjectInputStream(in);
			     
			     
			     
			     
			     
			     try {
					//Integer I= (Integer)objIn.readObject();
			    	strg= (Object)objIn.readObject();
					System.out.println("Paquet reçu (client"+i+""+ ") :"+strg);
					
					Class strgclass = strg.getClass();
					Field[] attrs = strgclass.getFields();
					
					
					
					La.add("Objet : "+strg);
				    La.add("ObjetClass : "+strgclass);
					for(int i = 0; i < attrs.length; i++)
					{
					    Field f = attrs[i];
					    String ClassName = f.getName() ;
					    Class SuperClass = f.getClass().getSuperclass();
					    Class Type=f.getType();
					 
					  
					    Attrs.add("["+i+"]"+f);
						Attrs.add("ClassNameA["+i+"] : "+ClassName);
						Attrs.add("SuperClassA["+i+"] : "+SuperClass);
						Attrs.add("TypeA["+i+"] : "+Type);
					    n=i;
					}
					La.add("NBRattributs = "+n) ;
					La.add("Attributs : "+Attrs);
						
					/*
					Method[] m = ((Class<? extends Object>) strg).getMethods();
	                
					  System.out.println("Il y a " + m.length + " méthodes dans cette classe");
					  //On parcourt le tableau de méthodes
					  for(int i = 0; i < m.length; i++)
					    System.out.println(m[i]);
					*/
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			     /*
			     System.out.println("Saisissez les attribut de la liste d'objet :");
				 strg = sct.nextLine();
				 for(int x=0;x<str.length();x++){
				     C[x] = str.charAt(x);
				 }
				 System.out.println("Vous avez saisi  : " + strg);
				 */
			     
			     
				
			     
			     objOut.writeObject(La);
			     System.out.println("Paquet envoyé (client"+i+") :"+La);
			     
			     i++;
			     
			     
				
		        s.close();
				
		} 
		 catch (IOException e) {System.err.println(e);}


	}

}

