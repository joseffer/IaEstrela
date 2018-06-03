package problema.metroParis;

import modelo.Estado;

public class EstadoMP implements Estado {
	private String nomeAcao = "";
	private int estacao;
	private Linha linha;
	private Baldeacao baldeacao;
	private ModeloMetro modeloMetro = ModeloMetro.getInstance();
	
	@Override
	public double custo(Estado p, String a) {
		// p = estado-pai; a = ação que gerou o estado atual; inicial = estado inicial do problema
		EstadoMP pai = (EstadoMP)p;
		int inicial = modeloMetro.getInicial().getEstacao();
		int c = modeloMetro.getDistancia(pai.getEstacao(), this.estacao);
		//Transformando o custo de km para minutos
		c = 2 * c;
		if(a == "baldear" && this.estacao != inicial ){
			c = c + 4;
		}
		return c;
	}
	
	@Override
	public double heuristica(Estado alvo) {
		EstadoMP estAlvo = (EstadoMP)alvo;
		int h = modeloMetro.getDistancia(this.getEstacao(), estAlvo.getEstacao());
		return h;
	}
	
	@Override
	public String toString() {
		return "EstadoMP [estacao=" + estacao + ", linha=" + linha.getNome()
				+ ", nomeAcao=" + nomeAcao + "]";
	}

	@Override
	public boolean equals(Estado e) {
		if(this.estacao == ((EstadoMP)e).getEstacao() && this.linha == ((EstadoMP)e).getLinha()){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean eFinal(Estado e){
		if(this.estacao == ((EstadoMP)e).getEstacao()){
			return true;
		}
		return false;
	}

	public EstadoMP(String nomeAcao, int estacao, Linha linha, Baldeacao baldeacao) {
		super();
		this.nomeAcao = nomeAcao;
		this.estacao = estacao;
		this.linha = linha;
		this.baldeacao = baldeacao;
	}
	

	public EstadoMP(int estacao, Linha linha, Baldeacao baldeacao) {
		super();
		this.estacao = estacao;
		this.linha = linha;
		this.baldeacao = baldeacao;
	}

	// Getters and Setters
	
	public Baldeacao getBaldeacao(){
		return this.baldeacao;
	}
	
	public void setBaldeacao(Baldeacao b){
		this.baldeacao = b;
	}
	
	@Override
	public String getAcao() {
		return this.nomeAcao;
	}

	public int getEstacao() {
		return estacao;
	}

	public void setEstacao(int estacao) {
		this.estacao = estacao;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

}
