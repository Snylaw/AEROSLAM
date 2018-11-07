import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class v_ajoutAvion extends JFrame {
	// Attributs priv�s	
	private JPanel panel;	
	//Labels
	private JLabel lblNomAvion;
	private JLabel lblNbPlace;
	//JTextField
	private JTextField jtfNomAvion;
	private JTextField jtfNbPlace;
	//JButton
	private JButton btnAjout;
	// Cr�ation de la barre de menu
	JMenuBar menu = new JMenuBar();
	
	// Cr�ation d'un "bouton menu" Produit dans la barre de menu
	JMenu menuRetour = new JMenu("Retour");


	// Cr�ation d'un �l�ment du menu BDD
	JMenuItem retour = new JMenuItem("Retour");
	
	public v_ajoutAvion(){
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
		
		panel.setLayout(new GridLayout(3,1,0,-30));
		
		// Instanciation dans le constructeur des zones de texte :
		this.lblNomAvion = new JLabel("Nom de l'avion : ");
		this.panel.add(this.lblNomAvion);
		
		this.jtfNomAvion = new JTextField();
		this.panel.add(this.jtfNomAvion);
		this.jtfNomAvion.setPreferredSize(new Dimension(150,30));
		
		this.lblNbPlace = new JLabel("Nombre de place : ");
		this.panel.add(this.lblNbPlace);
		
		this.jtfNbPlace = new JTextField();
		this.panel.add(this.jtfNbPlace);
		this.jtfNbPlace.setPreferredSize(new Dimension(150,30));
		
		this.btnAjout = new JButton("Ajouter");
		this.panel.add(this.btnAjout);
		
		//Ajout ActionListener
		this.btnAjout.addActionListener(new ActionAjouter());
		
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
	
	class ActionAjouter implements ActionListener{		
		private JLabel lblErreur;
		
		public void actionPerformed(ActionEvent e) {
			if(Modele.ajoutAvion(jtfNomAvion.getText(), jtfNbPlace.getText())){
				dispose();
				Vue fenetrePrincipal = new Vue();
			}
			else{
				// Instanciation dans le constructeur des zones de texte :
				lblErreur = new JLabel("Erreur de login ou password !");
				panel.add(lblErreur);
				
				getContentPane().revalidate();
			}
		}
	}
	
}
