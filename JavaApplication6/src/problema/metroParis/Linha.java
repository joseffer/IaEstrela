package problema.metroParis;

import java.util.ArrayList;

public class Linha {
	private ArrayList<Integer> numEstacoes = new ArrayList<Integer>();
	private String nome;

	public Linha(String nome, int[] estacoes) {
		this.nome = nome;
		for(int e: estacoes){
			this.numEstacoes.add(e);
		}
	}
	
	public void adicionarEstacao(int n){
		this.numEstacoes.add(n);
	}
	
	public int getIndexOfEstation(int e){
		return this.numEstacoes.indexOf(e);
	}

	/*
	 * Getters and Setters
	 */
	
	public ArrayList<Integer> getNumEstacoes() {
		return numEstacoes;
	}

	public void setNumEstacoes(ArrayList<Integer> numEstacoes) {
		this.numEstacoes = numEstacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
