package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	
	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio(" ( TU: Ciao ) ");
		partita.getConsole().mostraMessaggio( partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta() );
	}

}
