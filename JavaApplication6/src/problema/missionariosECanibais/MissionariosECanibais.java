package problema.missionariosECanibais;


import modelo.Problema;

public class MissionariosECanibais extends Problema {

	public MissionariosECanibais() {
		super();
		
		this.setInicial(new EstadoMC(3, 3, 'e', ""));
		this.setFinal(new EstadoMC(0, 0, 'd'));
		this.acoesValidas = new AcoesValidasMC();
	}
	
	

	
	
	

}
