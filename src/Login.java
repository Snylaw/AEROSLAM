
public class Login {

	//Attributs priv�s
	private String login;
	private String password;
	
	//Methode priv�
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
