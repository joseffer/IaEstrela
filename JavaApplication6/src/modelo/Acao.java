package modelo;


public interface Acao {
	
	public String actionName = "";
	
	public Estado actionFunction(Estado estado);
	
	public String getActionName();

}
