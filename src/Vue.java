import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vue extends JFrame {
	
	// Attributs priv�s	
	private JPanel panel;

	// Cr�ation de la barre de menu
	JMenuBar menu = new JMenuBar();
	
	// Cr�ation d'un "bouton menu" Produit dans la barre de menu
	JMenu menuAvion = new JMenu("Avions");
	JMenu menuQuitter = new JMenu("Quitter");


	// Cr�ation d'un �l�ment du menu BDD
	JMenuItem ajouter = new JMenuItem("Ajouter");
	JMenuItem consulter = new JMenuItem("Consulter");
	JMenuItem quitter = new JMenuItem("Quitter");

	
	public Vue(){
		
		// Squelette de base configuration fenetre
		this.setTitle("Aeroport");	// Titre de la fenetre
		this.setLocationRelativeTo(null);  	// Position la fenetre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Arrete le programme lorsqu'on ferme la Fenetre
		this.setSize(600,600); 	// Donne une taille a la fenetre � sont ouverture
		this.setResizable(false);	// Interdit la redimmension de la fenetre
		
		// Contenu du panel
		panel = new JPanel();
		
		// Ajout des �l�ments au menu nomm� menuBDD
		menuAvion.add(ajouter);
		menuAvion.add(consulter);
		menuQuitter.add(quitter);
		
		// Ajout du menuBDD dans la barre de menu
		menu.add(menuAvion);		
		
		// Ajout d'un listener appelant la classe menuActionQuitter lorsque l'on clique sur Quitter
		ajouter.addActionListener(new ActionAjouter());
		consulter.addActionListener(new ActionConsulter());
		
		// Permet de d�finir le menu utilis� dans la JFrame
		this.setJMenuBar(menu);
		
		this.getContentPane().add(panel);

		this.setVisible(true); 	// Par defaut la Fenetre est invisible

	}	
	
	class ActionAjouter implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			dispose();
			v_ajoutAvion fenetreAjoutAvion = new v_ajoutAvion();			
			//Ajout ActionListener
			/*btnAjout.addActionListener(new ActionAjout());*/
		}
	}
	
	class ActionConsulter implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
				dispose();
				Vue fenetrePrincipal = new Vue();
		}
	}
	
}
