package modelo;

import java.util.LinkedList;
import java.util.List;

public class Problema {
	
	private Estado EInicial;
	private Estado EFinal;
	public AcoesValidas acoesValidas;
		
	/*
	 * Recupera o estado Inicial
	 */
	public Estado getInicial(){
		return EInicial;
	}
	
	/*
	 * Configura estado inicial
	 */
	public void setInicial(Estado e){
		this.EInicial = e;
	}
	
	/*
	 * Configura estado final
	 */
	public void setFinal(Estado e){
		this.EFinal = e;
	}
	
	public Estado getFinal(){
		return EFinal;
	}
	
	/* 
	 * Verifica se o estado é meta do problema 
	 */
	public boolean meta(Estado estado){
		if(estado.eFinal(EFinal)){
			return true;
		}
		return false;
	}
	
	/*
	 * gera uma lista de sucessores de um estado dado
	 */
	public List<Estado> sucessores(Estado estado){
		List<Estado> suc = new LinkedList<Estado>();
		for(Acao a: acoesValidas.acoes(estado)){
			
			suc.add(a.actionFunction(estado));
		}
		return suc;
	}
	

}
