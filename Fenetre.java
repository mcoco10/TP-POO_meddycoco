import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Fenetre extends JFrame implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = getContentPane();
	private JPanel container = new JPanel();
	private JTextField jtf = new JTextField("INT");
	private JLabel label = new JLabel("ATTRIBUT  ");
	private JLabel Atts = new JLabel("(NAME) : ");
	private JButton con = new JButton("Confirmer");
    private JButton del = new JButton("Annuler");
    private JPanel tete =new JPanel() ;
    private JPanel saisie = new JPanel() ;
    private JPanel decis = new JPanel();
	private String ret ;
    int i,j ;
    
public Fenetre(int n){
	
	this.i = n ;
	
    this.setTitle("Saisie Valeur Attribut");
    this.setSize(400, 400);
    this.setLocationRelativeTo(null);
  
 
    Font police = new Font("DotumChe",Font.ITALIC, 14);
    Font police2 = new Font("Lucida Fax",Font.BOLD, 23);
    label.setFont(police2);
    jtf.setFont(police);
    jtf.setPreferredSize(new Dimension(150, 30));
   
    
    
    GridLayout g1 = new GridLayout();
    g1.setColumns(1);
    g1.setRows(3);
    g1.setHgap(10); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    g1.setVgap(10); //Cinq pixels d'espace entre les lignes (V comme Vertical) 
    GridLayout g2 = new GridLayout();
    g2.setColumns(2);
    g2.setRows(i);
    g2.setHgap(10); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    g2.setVgap(10);
    //Ou en abrégé : GridLayout gl = new GridLayout(3, 2, 5, 5);
    c.setLayout(g1);
    
    tete.add(label);
    tete.setBackground(Color.yellow);
    c.add(tete);
    	
    //saisie.setLayout(g2);
    saisie.add(Atts);
    saisie.add(jtf);
    saisie.setBackground(Color.yellow);
    c.add(saisie);
    
    
	con.setPreferredSize(new Dimension(110,30));
    del.setPreferredSize(new Dimension(110,30));
    
    //decis.setLayout(new GridLayout(1,2,20,20));
    decis.add(con);
    decis.add(del); 
    decis.setBackground(Color.yellow);
    
    con.addActionListener(this);
    del.addActionListener(this);
    c.add(decis);
    c.setBackground(Color.yellow);
    
    //container.setLayout(g1);
    //container.add(tete);
    //container.add(saisie);
    //container.add(decis);
    //container.setBackground(Color.yellow);
    
    //this.setContentPane(container); 
    this.setContentPane(c); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
  }

 
public static void main (String[] args){
	Fenetre fen = new Fenetre(0);
}

public void go(){
	System.out.println(""+ret);
	this.setVisible (false);
    this.dispose();
}


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource() == con){
		ret=jtf.getText();
		
		go();
	}
	    

	if(arg0.getSource() == del)
	{
		this.setVisible (false);
	    this.dispose();
	}
}

}