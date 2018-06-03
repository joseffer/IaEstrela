package views;

import java.util.LinkedList;
import java.util.ListIterator;

import modelo.No;

public class ResultConsoleView {
	LinkedList<No>result = new LinkedList<No>();

	public ResultConsoleView(LinkedList<No> result) {
		super();
		this.result = result;
	}
	
	
	public void show(){
		//Exibir caminho inteiro ate o nó atual:
		No n = new No(null);
		System.out.println("Resultado da Busca:");
		ListIterator<No> iteracao = this.result.listIterator();
		if(! iteracao.hasNext()){
			System.out.println("Não encontrou soluções");
		}else{
			while(iteracao.hasNext()){
				n = iteracao.next();
				System.out.println(n.estado);
			}
			System.out.println("Custo do caminho: " + n.custoCaminho);
			System.out.println("Profundidade do alvo: " + n.profundidade);
			
		}
	}

}
