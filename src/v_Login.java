import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class v_Login extends JFrame {
	
	// Attributs privés
		//Labels
	private JPanel panel;
	private JLabel lblLogin;
	private JLabel lblPassword;
		//JTextField
	private JTextField jtfLogin;
	private JTextField jtfPassword;
		//JButton
	private JButton btnLogin;

	
	public v_Login(){
		
		// Squelette de base configuration fenetre
		this.setTitle("Aeroport");	// Titre de la fenetre
		this.setLocationRelativeTo(null);  	// Position la fenetre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Arrete le programme lorsqu'on ferme la Fenetre
		this.setSize(250,250); 	// Donne une taille a la fenetre à sont ouverture
		this.setResizable(false);	// Interdit la redimmension de la fenetre
		
		// Contenu du panel
		this.panel = new JPanel();
		
		// Instanciation dans le constructeur des zones de texte :
		this.lblLogin = new JLabel("Login : ");
		this.panel.add(this.lblLogin);
		
		this.jtfLogin = new JTextField();
		this.panel.add(this.jtfLogin);
		this.jtfLogin.setPreferredSize(new Dimension(150,30));
		
		this.lblPassword = new JLabel("Password : ");
		this.panel.add(this.lblPassword);
		
		this.jtfPassword = new JTextField();
		this.panel.add(this.jtfPassword);
		this.jtfPassword.setPreferredSize(new Dimension(150,30));
		
		this.btnLogin = new JButton("Login");
		this.panel.add(this.btnLogin);
		
		//Ajout ActionListener
		this.btnLogin.addActionListener(new ActionLogin());
		
		
		this.getContentPane().add(panel);

		this.setVisible(true); 	// Par defaut la Fenetre est invisible

	}
	
	class ActionLogin implements ActionListener{
		private JLabel lblErreur;
		
		public void actionPerformed(ActionEvent e) {
			if(Modele.connexionAdmin(jtfLogin.getText(), jtfPassword.getText())){
				dispose();
				Vue fenetrePrincipal = new Vue();
			}
			else{
				// Instanciation dans le constructeur des zones de texte :
				lblLogin = new JLabel("Erreur de login ou password !");
				panel.add(lblLogin);
				
				getContentPane().revalidate();
			}
		}
	}
	
}
