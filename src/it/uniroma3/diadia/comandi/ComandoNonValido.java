package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("Comando non valido!");
	}

	@Override
	public void setParametro(String parametro) {
		return;
	}

}
