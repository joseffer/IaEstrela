package problema.metroParis.acoes;

import problema.metroParis.EstadoMP;
import modelo.Acao;
import modelo.Estado;

public class Ir implements Acao {
	private String actionName = "ir";
	private EstadoMP estado;
	
	public Ir(EstadoMP e){
		this.estado = new EstadoMP(e.getEstacao(), e.getLinha(), e.getBaldeacao()); 
	}
	
	@Override
	public Estado actionFunction(Estado estado) {
		EstadoMP e = new EstadoMP(this.actionName,this.estado.getEstacao(),this.estado.getLinha(), this.estado.getBaldeacao());
		return e;
	}

	@Override
	public String getActionName() {
		// TODO Auto-generated method stub
		return this.actionName;
	}

}
