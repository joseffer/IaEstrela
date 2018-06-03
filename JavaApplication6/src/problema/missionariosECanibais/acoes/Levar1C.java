package problema.missionariosECanibais.acoes;

import problema.missionariosECanibais.EstadoMC;
import modelo.Acao;
import modelo.Estado;

public class Levar1C implements Acao {
	private char barco;
	public String actionName = "Levar 1 Canibal";
	@Override
	public Estado actionFunction(Estado estado) {
		EstadoMC est = (EstadoMC)estado;
		EstadoMC e;
		
		if (est.getBarco() == 'e'){
			barco = 'd';
			e = new EstadoMC(est.getMissionarios(), est.getCanibais() - 1, barco, this.actionName);
		}else{
			barco = 'e';
			e = new EstadoMC(est.getMissionarios(), est.getCanibais() + 1, barco, this.actionName);
		}
		
		return e;
	}
	@Override
	public String getActionName() {
		return this.actionName;
	}

}
