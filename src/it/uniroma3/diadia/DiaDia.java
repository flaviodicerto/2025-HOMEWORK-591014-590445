package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * CLASSE PRINCIPALE DI DiaDia, UN SEMPLICE GIOCO DI RUOLO AMBIENTATO AL DIA.
 * PER GIOCARE CREA UN'ISTANZA DI QUESTA CLASSE E INVOCA IL METODO GIOCA
 * 
 * QUESTA E' LA CLASSE PRINCIPALE CHE CREA ED ISTANZIA TUTTE LE ALTRE
 *
 * @author  591014 - 590445          
 * @version 1.0
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO console;

	public DiaDia(IO console) {
		this.partita = new Partita();
		this.console = console;
		this.partita.setConsole(console);
	}

	
	public void gioca() {
		String istruzione; 

		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = this.console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * PROCESSA UN'ISTRUZIONE
	 *
	 * @return true SE L'ISTRUZIONE E' ESEGUITA ED IL GIOCO CONTINUA,
	 * 		   false ALTRIMENTI
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.console.mostraMessaggio("HAI VINTO !!");
		if (this.partita.getGiocatore().getCFU()==0)
			this.console.mostraMessaggio("Hai esaurito i CFU..");

		return this.partita.isFinita();
	}   


	/**
	 * METODO DA CUI COMINCIA L'ESECUZIONE DEL PROGRAMMA
	 * METODO PRINCIPALE
	 * @param argc
	 * @throws Exception 
	 */
	public static void main(String[] argc) {
		IO console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.partita.setLabirinto();
		gioco.gioca();
	}
}