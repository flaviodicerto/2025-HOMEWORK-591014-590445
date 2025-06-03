package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * COMANDO CHE PERMETTE ALL'UTENTE DI GUARDARE A CHE STATO DEL GIOCO SI TROVA
 * @author 591014 - 590445 
 * @version 1.0
 * @see FabbricaDiComandiFisarmonica
 *
 */
public class ComandoGuarda extends AbstractComando{
	
	//private String numeroComando;
	
	public ComandoGuarda() {
		super();
	}
	
	public ComandoGuarda(String tipoComando) {
		super(tipoComando);
	}

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			partita.getConsole().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			partita.getConsole().mostraMessaggio("CFU rimasti:  " + partita.getGiocatore().getCFU());
			return;
		}
		if(this.getParametro().equals("peso")) {
			partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso().toString());
			return;
		}
		if(this.getParametro().equals("nome")) {
			partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
			return;
		}
		if(this.getParametro().equals("raggruppato")) {
			partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso().toString());
			return;
		}
		partita.getConsole().mostraMessaggio(" -> COMANDO NON VALIDO <-");
		return;
	}

}
