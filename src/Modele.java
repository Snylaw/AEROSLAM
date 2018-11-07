import java.sql.*;
import java.util.ArrayList;

public class Modele {
	
	//Attributs privés
	private static Connection connexion;
	private static PreparedStatement st;
	private static ResultSet rs;
	private static String req = "";
	
	//Methodes statiques
	
	
	//Methode de connexion à la BDD
	public static boolean connexionBDD(){
		boolean rep = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/aeroport","root","");
			rep = true;
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Driver non chargé ! " + e);
		}
		catch (SQLException e) 
		{	
			e.printStackTrace();
			System.out.println("Erreur de connexion à la base de donnée : " + e);
		}
		return rep;
	}
	
	//Methode de déconnexion de la BDD
	public static boolean deconnexionBDD(){
		//Fermeture de la connexion
		boolean rep = false;
		try {
			connexion.close();
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur de déconnexion à la base de donnée : " +e);
		}
		return rep;
	}
	
	public static boolean connexionAdmin(String login, String pwd){
		connexionBDD();
		int count = 0;
		
		try{
			
			st = connexion.prepareStatement("SELECT COUNT(login) FROM admin WHERE login= ? AND pwd = ?");
			
			st.setString(1, login);
			st.setString(2, pwd);
			
			rs = st.executeQuery();
			
			while(rs.next()){
				count = rs.getInt(1);
			}
			
			rs.close();
			st.close();

			deconnexionBDD();
			
			
		} catch (SQLException e){
			return false;
		}
		
		if(count == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Methode pour ajouter un contact
		public static boolean ajoutAvion(String nomAvion, String nbPlace){
			connexionBDD();
			//INSERT
			//req = "INSERT INTO contacts (Nom, Prenom, Email, Commentaire) VALUES (?,?,?,?)";
			int count = 0;
			try {
				st = connexion.prepareStatement("INSERT INTO avion (nomAvion, nbPlace) VALUES (?,?)");
				
				st.setString(1, nomAvion);
				st.setString(1, nbPlace);
				
			    count = st.executeUpdate();	
				
			} catch (SQLException e) {
				return false;
			}
			
			if(count == 1){
				deconnexionBDD();
				return true;
			}
			else{
				deconnexionBDD();
				return false;
			}
			
			
		}
	
	
	//Methode pour afficher tous les vols
	/*public static ArrayList<Vol> getLesVols(){
		connexionBDD();
		
		ArrayList<Vol> lesContacts = new ArrayList<Vol>();
		Contact unVol;
		//SELECT
		req = "SELECT * FROM Vol";
		try {
			rs = st.executeQuery(req);
			while(rs.next()){
				int num = rs.getInt("Numero");
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String email = rs.getString(4);
				String commentaire = rs.getString(5);
				
				unContact = new Contact(num,nom,prenom,email,commentaire);
				lesContacts.add(unContact);
			}
			
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		deconnexionBDD();
		return lesContacts;
	}*/
}
