package problema.metroParis;

import java.util.ArrayList;

import problema.metroParis.acoes.Baldear;
import problema.metroParis.acoes.Ir;

import modelo.Acao;
import modelo.AcoesValidas;
import modelo.Estado;

public class AcoesValidasMP implements AcoesValidas {
	ArrayList<Acao>acoes;
	ModeloMetro modeloMetro = ModeloMetro.getInstance();
	
	@Override
	public ArrayList<Acao> acoes(Estado estado) {
		acoes = new ArrayList<Acao>();
		EstadoMP est = (EstadoMP)estado;
		EstadoMP nextEst = modeloMetro.nextEst(est);
		EstadoMP prevEst = modeloMetro.previousEst(est);
		
		if(nextEst != null){
			acoes.add(new Ir(nextEst));
		}
		
		if (prevEst != null){
			acoes.add(new Ir(prevEst));
		}
		
		if(est.getBaldeacao() != null){
			int numEstacao = est.getEstacao();
			Baldeacao b = est.getBaldeacao();
			Linha l = est.getLinha();
			l = est.getBaldeacao().trocaLinha(l);
			EstadoMP baldEst = new EstadoMP(numEstacao, l, b);
			acoes.add(new Baldear(baldEst));
		}
		
		return acoes;
	}

}
