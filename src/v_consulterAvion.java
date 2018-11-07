import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class v_consulterAvion extends JFrame {
	// Attributs priv�s	
	private JPanel panel;	
	// Cr�ation de la barre de menu
	JMenuBar menu = new JMenuBar();
	
	// Cr�ation d'un "bouton menu" Produit dans la barre de menu
	JMenu menuRetour = new JMenu("Retour");


	// Cr�ation d'un �l�ment du menu BDD
	JMenuItem retour = new JMenuItem("Retour");
	
	public v_consulterAvion(){
		// Squelette de base configuration fenetre
		this.setTitle("Aeroport");	// Titre de la fenetre
		this.setLocationRelativeTo(null);  	// Position la fenetre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Arrete le programme lorsqu'on ferme la Fenetre
		this.setSize(600,600); 	// Donne une taille a la fenetre � sont ouverture
		this.setResizable(false);	// Interdit la redimmension de la fenetre
		
		// Contenu du panel
		panel = new JPanel();
		
		// Ajout des �l�ments au menu nomm� menuBDD
		menuRetour.add(retour);
		
		// Ajout du menuBDD dans la barre de menu
		menu.add(menuRetour);	
		
		// Ajout d'un listener appelant la classe menuActionQuitter lorsque l'on clique sur Quitter
		retour.addActionListener(new ActionRetour());
		
		
		
		// Permet de d�finir le menu utilis� dans la JFrame
		this.setJMenuBar(menu);
		
		this.getContentPane().add(panel);

		this.setVisible(true); 	// Par defaut la Fenetre est invisible		
	}
	
	class ActionRetour implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
				dispose();
				Vue fenetrePrincipal = new Vue();
		}
	}
	
}
