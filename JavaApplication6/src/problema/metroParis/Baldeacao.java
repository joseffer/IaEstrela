package problema.metroParis;

public class Baldeacao {
	private Linha linha1;
	private Linha linha2;
	
	public Baldeacao(Linha linha1, Linha linha2) {
		this.linha1 = linha1;
		this.linha2 = linha2;
	}

	/*
	 * Getters and Setters
	 */
	public Linha getLinha1() {
		return linha1;
	}

	public void setLinha1(Linha linha1) {
		this.linha1 = linha1;
	}

	public Linha getLinha2() {
		return linha2;
	}

	public void setLinha2(Linha linha2) {
		this.linha2 = linha2;
	}
	
	public Linha trocaLinha(Linha l){
		if (l == this.linha1){
			return linha2;
		}
		return linha1;
	}
	

}
