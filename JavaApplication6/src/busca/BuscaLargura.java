package busca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import modelo.Estado;
import modelo.No;
import modelo.Problema;

public class BuscaLargura {
	//public LinkedList<No> borda;
	private No n;
	LinkedList<No> borda = new LinkedList<No>();
	
	/*
	 * Método para buscar a solução do problema
	 */
	public List<No> buscar(Problema problema){
		
		borda.add(new No(problema.getInicial()));
		while(!borda.isEmpty()){
			n = borda.remove(0);
			//System.out.println(n.profundidade);
			if (problema.meta(n.estado)){
				return n.CaminhoSolucao();
			}
			borda.addAll(expandir(n, problema));
			//escreveBorda();
		}
		System.out.println("Sem solução");
		return null;
	}
	
	/*
	 * Método para expandir uma árvore (Baseado no livro)
	 */
	public List<No> expandir(No n, Problema problema){
		List<No> sucessores = new ArrayList<No>();
		No s;
			List<Estado>eSucessores = problema.sucessores(n.estado);
			if (eSucessores.size() > 0 ){
		    for(Estado e: eSucessores){
				if(! poda(e)){
					s = new No(e, n, e.getAcao());
					sucessores.add(s);
				}
				/*
				else{
					System.out.println("Poda!" + e.toString());
				}
				*/
			}
		}
		return sucessores;
	}
	
	public Boolean poda(Estado e){
		ListIterator<No> iteracao = borda.listIterator();
		
		while(iteracao.hasNext()){
			No n = iteracao.next();
			if(e.equals(n.estado)){
				return true;
			}
		}
		return false;
	}
	
	public void escreveBorda(){
		ListIterator<No> iteracao = borda.listIterator();
		while(iteracao.hasNext()){
			No n = iteracao.next();
			System.out.println(n.estado.toString() + " profundidade: " + n.profundidade);
		}
	}
	
	
}

