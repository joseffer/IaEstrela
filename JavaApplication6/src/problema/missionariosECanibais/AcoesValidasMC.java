package problema.missionariosECanibais;

import java.util.ArrayList;

import problema.missionariosECanibais.acoes.Levar1C;
import problema.missionariosECanibais.acoes.Levar1M;
import problema.missionariosECanibais.acoes.Levar1M1C;
import problema.missionariosECanibais.acoes.Levar2C;
import problema.missionariosECanibais.acoes.Levar2M;
import modelo.Acao;
import modelo.AcoesValidas;
import modelo.Estado;

public class AcoesValidasMC implements AcoesValidas {
	
	Acao levar1M = new Levar1M();
	Acao levar2C = new Levar2C();
	Acao levar2M = new Levar2M();
	Acao levar1C = new Levar1C();
	Acao levar1M1C = new Levar1M1C();
	ArrayList<Acao> acoes = new ArrayList<Acao>();
	
	public AcoesValidasMC() {
		super();
		acoes.add(levar1M);
		acoes.add(levar1C);
		acoes.add(levar2M);
		acoes.add(levar2C);
		acoes.add(levar1M1C);
	}
	
	@Override
	public ArrayList<Acao> acoes(Estado estado) {
		ArrayList<Acao> acoesValidas = new ArrayList<Acao>();
		for(Acao a: acoes){
			//System.out.println(a.toString());
			EstadoMC e = (EstadoMC)a.actionFunction(estado);
			//Avaliar o estado criado. Se for válido, insiro em um set
			if(estadoValido(e)){
				acoesValidas.add(a);
			}
		}
		
		//System.out.println(acoesValidas.toString());
		return acoesValidas;
	}
	
	public Boolean estadoValido(EstadoMC e){
		if(e.getCanibais() < 0 || e.getCanibais() > 3){
			return false;
		}
		if (e.getMissionarios() < 0 || e.getMissionarios() > 3){
			return false;
		}
		if(e.getMissionarios() != 0 && e.getMissionarios() != 3 && e.getMissionarios() != e.getCanibais()){
			return false;
		}
		return true;
	}

}
