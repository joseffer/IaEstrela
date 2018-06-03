package modelo;

import java.util.LinkedList;
import java.util.List;

public class No {
	
	public Estado estado; // O estado vinculado ao nó
	public No pai = null; // O pai deste nó. É null quando o estado é inicial;
	public int profundidade = 0; //A profundidade do nó;
	public double custoCaminho = 0; //custo do caminho inteiro para gerar este nó
	
	
	/*
	 * Construtor para estado inicial
	 */
	public No(Estado estado){
		this.estado = estado;
		custoCaminho = 0;
	}
	
	/*
	 * Construtor para demais estados
	 */
	public No(Estado estado, No pai, String acao) {
		this.estado = estado;
		this.pai = pai;
		profundidade = pai.profundidade + 1;
		custoCaminho = pai.custoCaminho + estado.custo(this.pai.estado,acao);
	}
	
	@Override
	public boolean equals(Object object) {
		No n = (No)object;
		if(this.estado.equals(n.estado)){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "No [estado=" + estado.toString() + ", pai=" + pai + ", profundidade="
				+ profundidade + "]";
	}

	public List<No> CaminhoSolucao(){
		LinkedList<No> caminho = new LinkedList<No>();
		No n = this;
		
		while(n.pai != null){
			caminho.push(n);
			n = n.pai;
		}
		//Salvar o estado inicial no caminho
		caminho.push(n);
		
		return caminho;
	}
	
	
}
