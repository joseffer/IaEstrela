package problema.missionariosECanibais;

import modelo.Estado;

public class EstadoMC implements Estado {
	private String nomeAcao = "";
	private int missionarios;
	private int canibais;
	private char barco; // e ou d
	
	public EstadoMC(int m, int c, char b, String a){
		this.missionarios = m;
		this.canibais = c;
		this.barco = b;
		this.nomeAcao = a;
	}
	
	public EstadoMC(int m, int c, char b){
		this.missionarios = m;
		this.canibais = c;
		this.barco = b;
	}
	
	public int getMissionarios(){
		return this.missionarios;
	}
	
	public int getCanibais(){
		return this.canibais;
	}
	
	public char getBarco(){
		return this.barco;
	}
	
	@Override
	public double custo(Estado p, String a) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getAcao() {
		// TODO Auto-generated method stub
		return this.nomeAcao;
	}
	
	@Override
	public boolean equals(Estado e){
		if(this.missionarios == ((EstadoMC) e).getMissionarios()  
				&& this.canibais == ((EstadoMC)e).getCanibais()
				&& this.barco == ((EstadoMC)e).getBarco()){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean eFinal(Estado e){
		if(this.equals(e)){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "EstadoMC [barco=" + barco + ", canibais=" + canibais
				+ ", missionarios=" + missionarios +  ", acão=" + this.getAcao() + "]";
	}

	@Override
	public double heuristica(Estado alvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
