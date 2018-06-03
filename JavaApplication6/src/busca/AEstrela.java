package busca;

import java.util.LinkedList;

import modelo.Estado;
import modelo.No;
import modelo.Problema;

public class AEstrela extends BuscaMelhorEscolha{

	/*
	 * Método abstrato para escolher o melhor nó na lista aberta
	 */
	@Override
	public No melhorNo(LinkedList<No> lista, Problema problema) {
		// TODO Auto-generated method stub
		No melhor = lista.getFirst();
		for(No n: lista){
			if(f(n, problema.getFinal()) <= f(melhor, problema.getFinal())){
				melhor = n;
			}
		}
		lista.remove(melhor);
		return melhor;
	}
	
	/*
	 * Método para calcular f(n)
	 */
	@Override
	protected double f(No n, Estado alvo){
		return n.custoCaminho + n.estado.heuristica(alvo);
	}

	/*
	 * (non-Javadoc)
	 * @see busca.BuscaMelhorEscolha#listaFechadaContemNo(modelo.No)
	 */
	@Override
	public boolean listaFechadaContemNo(No n) {
		for(No no: this.listFechada){
			Estado e1 = n.estado;
			Estado e2 = no.estado;
			if(e1.equals(e2)){
				return true;
			}
		}
		return false;
	}
}
