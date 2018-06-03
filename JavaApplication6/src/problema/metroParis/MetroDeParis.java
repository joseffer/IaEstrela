package problema.metroParis;

import modelo.Problema;

public class MetroDeParis extends Problema {
	ModeloMetro modeloMetro = ModeloMetro.getInstance();
	
	public MetroDeParis() {
		super();
		EstadoMP i = new EstadoMP(1, modeloMetro.getLinha(1), modeloMetro.getBaldeacao(1));
		EstadoMP f = new EstadoMP(14, modeloMetro.getLinha(14), modeloMetro.getBaldeacao(14));
		modeloMetro.setInicial(i);
		this.setInicial(i);
		this.setFinal(f);
		this.acoesValidas = new AcoesValidasMP();
	}

}
