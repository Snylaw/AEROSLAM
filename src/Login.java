
public class Login {

	//Attributs privés
	private String login;
	private String password;
	
	//Methode privé
	public Login(String unLogin, String unPassword){
		this.login = unLogin;
		this.password = unPassword;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	
}
