package modelo;

public interface Estado {
	
	
	/*
	 * Calcula o custo para geração do estado;
	 * Parâmetros: 
	 * 	- Estado pai p, onde é aplicada a ação
	 * 	- Ação a, aplicada ao estado pai gerando este estado
	 */
	public double custo(Estado p, String a);
	
	public double heuristica(Estado alvo);
	
	public String getAcao();

	boolean equals(Estado e);
	
	boolean eFinal(Estado e);
	
	
}
