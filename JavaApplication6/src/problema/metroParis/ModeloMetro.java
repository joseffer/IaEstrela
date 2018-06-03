package problema.metroParis;

import java.util.ArrayList;

/*
 * Esta classe armazena todas as informações disponíveis no Mapa e na tabela fornecida
 * pelo problema:
 * 1) Distancia entre estações;
 * 2) Estações por linha de metrô
 * 3) Baldeações possíveis
 * 4) Estações que possuem baldeação
 */
public class ModeloMetro {
	private static ModeloMetro tabelaInstance;
	private int distancia[][] = new int[14][14];
	private EstadoMP inicial;
	private ArrayList<Linha> linhasMetro = new ArrayList<Linha>();
	private ArrayList<Baldeacao> baldeacao = new ArrayList<Baldeacao>();
	
	
	private ModeloMetro(){
		int d[][] = {
				{0,11,20,27,40,43,39,28,18,10,18,30,30,32},
				{11,0,9,16,29,32,28,19,11,4,17,23,21,24},
				{20,9,0,7,20,22,19,15,10,11,21,21,13,18},
				{27,16,7,0,13,16,12,13,13,18,26,21,11,17},
				{40,29,20,13,0,3,2,21,25,31,38,27,16,20},
				{43,32,22,16,3,0,4,23,28,33,41,30,17,20},
				{39,28,19,12,2,4,0,22,25,29,38,28,13,17},
				{28,19,15,13,21,23,22,0,9,22,18,7,25,30},
				{18,11,10,13,25,28,25,9,0,13,12,12,23,28},
				{10,4,11,18,31,33,29,22,13,0,20,27,20,23},
				{18,17,21,26,38,41,38,18,12,20,0,15,35,39},
				{30,23,21,21,27,30,28,7,12,27,15,0,31,37},
				{30,21,13,11,16,17,13,25,23,20,35,31,0,5},
				{32,24,18,17,20,20,17,30,28,23,39,37,5,0}
		};
		this.distancia = d;
		
		int az[] = {1,2,3,4,5,6};
		int am[] = {10,2,9,8,5,7};
		int vm[] = {11,9,3,13};
		int vd[] = {12,8,4,13,14};
		
		Linha azul = new Linha("azul",az);
		Linha amarela = new Linha("amarela", am);
		Linha vermelha = new Linha("vermelha",vm);
		Linha verde = new Linha("verde", vd);
		
		this.linhasMetro.add(azul);
		this.linhasMetro.add(amarela);
		this.linhasMetro.add(vermelha);
		this.linhasMetro.add(verde);
		
		this.baldeacao.add(new Baldeacao(azul, amarela));
		this.baldeacao.add(new Baldeacao(azul, vermelha));
		this.baldeacao.add(new Baldeacao(azul, verde));
		this.baldeacao.add(new Baldeacao(amarela, vermelha));
		this.baldeacao.add(new Baldeacao(amarela, verde));
		this.baldeacao.add(new Baldeacao(vermelha, verde));
		
	}
	
	public static ModeloMetro getInstance(){
		if(tabelaInstance == null){
			tabelaInstance = new ModeloMetro();
		}
		return tabelaInstance;
	}
	
	/*
	 * Calcula a distancia entre duas estaçoes
	 */
	public int getDistancia(int origem, int destino){
		origem  = origem -1;
		destino = destino -1;
		return this.distancia[origem][destino];
	}
	
	/*
	 * Identifica se existe baldeação em determinada estação
	 */
	public Baldeacao getBaldeacao(int e){
		switch (e) {
		case 2:
			return this.baldeacao.get(0);
		case 3:
			return this.baldeacao.get(1);
		case 4:
			return this.baldeacao.get(2);
		case 5:
			return this.baldeacao.get(0);
		case 8:
			return this.baldeacao.get(4);
		case 9:
			return this.baldeacao.get(3);
		case 13:
			return this.baldeacao.get(5);

		default:
			return null;
		}
	}
	
	/*
	 * Retorna a próxima estação dentro de uma linha
	 */
	public EstadoMP nextEst(EstadoMP e){
		//pegando os dados da estação atual
		int numeroEst = e.getEstacao();
		Linha l = e.getLinha();
		Baldeacao b = e.getBaldeacao();
		
		//Definindo próxima estação:
		int index = l.getIndexOfEstation(numeroEst);
		if(index + 1 < l.getNumEstacoes().size()){
			int proxEst = l.getNumEstacoes().get(index + 1);
			b = this.getBaldeacao(proxEst);
			return new EstadoMP(proxEst, l, b);
		}else{
			return null;
		}
	}
	
	/*
	 * Retorna a estação anterior dentro de uma linha
	 */
	public EstadoMP previousEst(EstadoMP e){
		//pegando os dados da estação atual
		int numeroEst = e.getEstacao();
		Linha l = e.getLinha();
		Baldeacao b = e.getBaldeacao();
		
		//Definindo próxima estação:
		int index = l.getIndexOfEstation(numeroEst);
		if(index -1 >= 0){
			int prevEst = l.getNumEstacoes().get(index - 1);
			b = this.getBaldeacao(prevEst);
			return new EstadoMP(prevEst, l, b);
		}else{
			return null;
		}
		
	}
	
	public Linha getLinha(int est){
		for (Linha l: linhasMetro){
			if(l.getNumEstacoes().contains(est)){
				return l;
			}
		}
		return null;
	}
	
	public void setInicial(EstadoMP inicial){
		this.inicial = inicial;
	}
	
	public EstadoMP getInicial(){
		return this.inicial;
	}

}
