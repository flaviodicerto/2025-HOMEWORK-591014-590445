package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando{
	private String parametro;
	
	public AbstractComando() {
		this.parametro = null;
	}
	
	public AbstractComando(String parametro) {
		this.parametro = parametro;
	}

	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public abstract void esegui(Partita partita);
	
}