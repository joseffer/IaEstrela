package busca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import modelo.Estado;
import modelo.No;
import modelo.Problema;

public abstract class BuscaMelhorEscolha {
	public LinkedList<No> listAberta = new LinkedList<No>(); 	//Lista dos estados para analisar.
	public LinkedList<No> listFechada = new LinkedList<No>();	//Lista dos estados analisados.
	public No n;
	
	public List<No> buscar(Problema problema){
		listAberta.add(new No(problema.getInicial()));
		while (! listAberta.isEmpty()){
			n = melhorNo(listAberta, problema);
			if (problema.meta(n.estado)){
				return n.CaminhoSolucao();
			}
			listFechada.add(n);
			//Criando os sucessores de n:
			for(No no: expandir(n, problema)){
				if(!listFechada.contains(no)){
					listAberta.add(no);
				}
			}
		}
		return null;
	}
	
	/*
	 * Método abstrato para escolher o melhor nó na lista aberta
	 */
	public abstract No melhorNo(LinkedList<No> lista, Problema problema);
	
	/*
	 * Método para verificar se um nó existe em uma lista...
	 */
	public abstract boolean listaFechadaContemNo(No n);
	
	/*
	 * Método para calcular f(n)
	 */
	protected abstract double f(No n, Estado alvo);
	
	/*
	 * Método para expandir uma árvore (Baseado no livro)
	 */
	public List<No> expandir(No n, Problema problema){
		List<No> sucessores = new ArrayList<No>();
		No s;
		List<Estado>eSucessores = problema.sucessores(n.estado);
		if (eSucessores.size() > 0 ){
		   for(Estado e: eSucessores){
				s = new No(e, n, e.getAcao());
				sucessores.add(s);
		   }
		}
		return sucessores;
	}
	
}
