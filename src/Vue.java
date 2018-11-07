import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vue extends JFrame {
	
	// Attributs privés	
	private JPanel panel;

	// Création de la barre de menu
	JMenuBar menu = new JMenuBar();
	
	// Création d'un "bouton menu" Produit dans la barre de menu
	JMenu menuAvion = new JMenu("Avions");
	JMenu menuQuitter = new JMenu("Quitter");


	// Création d'un élément du menu BDD
	JMenuItem ajouter = new JMenuItem("Ajouter");
	JMenuItem consulter = new JMenuItem("Consulter");
	JMenuItem quitter = new JMenuItem("Quitter");

	
	public Vue(){
		
		// Squelette de base configuration fenetre
		this.setTitle("Aeroport");	// Titre de la fenetre
		this.setLocationRelativeTo(null);  	// Position la fenetre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Arrete le programme lorsqu'on ferme la Fenetre
		this.setSize(600,600); 	// Donne une taille a la fenetre à sont ouverture
		this.setResizable(false);	// Interdit la redimmension de la fenetre
		
		// Contenu du panel
		panel = new JPanel();
		
		// Ajout des éléments au menu nommé menuBDD
		menuAvion.add(ajouter);
		menuAvion.add(consulter);
		menuQuitter.add(quitter);
		
		// Ajout du menuBDD dans la barre de menu
		menu.add(menuAvion);		
		
		// Ajout d'un listener appelant la classe menuActionQuitter lorsque l'on clique sur Quitter
		ajouter.addActionListener(new ActionAjouter());
		consulter.addActionListener(new ActionConsulter());
		
		// Permet de définir le menu utilisé dans la JFrame
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
