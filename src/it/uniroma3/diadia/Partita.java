package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * QUESTA CLASSE MODELLA UNA PARTITA DEL GIOCO
 *
 * @author  591014 - 590445 
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO console;
	private boolean finita;
	
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.finita = false;
	}
	
	public Partita(Labirinto l) {
		this.labirinto = l;
		this.giocatore = new Giocatore();
		this.finita = false;
	}

    /**
     * METODO "GETTER" CHE RESTITUISCE IL GIOCATORE
     * @return IL GIOCATORE
     */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * METODO "GETTER" CHE RESTITUISCE IL LABIRINTO
	 * @return IL LABIRINTO
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * METODO "SETTER" DEL GIOCATORE UTILE LI' DOVE SI 
	 * DECIDESSE DI VOLER INSERIRE PIU' DI UN GIOCATORE
	 * @param giocatore;
	 */
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
	
	/**
	 * METODO "SETTER" DEL LABIRINTO UTILE LI' DOVE SI
	 * DECIDESSE DI VOLER INSERIRE PIU' DI UN LABIRINTO
	 * @param labirinto
	 */
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
	}
	public void setLabirinto() {
		this.labirinto.creaStanze();
	}
	
	/**
	 * RESTITUISCE true SE E SOLO SE LA PARTITA E' FINITA 
	 * PER UNO DEI TRE MOTIVI SEGUENTI:
	 * - PARTITA FINITA PERCHE' VINTA;
	 * - PARTITA FINITA PERCHE' ESAURITI I CFU;
	 * - PARTITA FINITA PERCHE' E' IL GIOCATORE A DESIDERARLO;
	 * 
	 * @return true SE LA PARTITA E' FINITA
	 */
	public boolean isFinita() {
		return finita || this.vinta() || (this.giocatore.getCFU()==0);
	}

	/**
	 * IMPOSTA LA PARTITA COME FINITA
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * RESTITUISCE "true" SE E SOLO SE LA PARTITA E' STATA VINTA
	 * @return true SE LA PARTITA E' VINTA
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * METODO CHE RESTITUISCE LA CONSOLE PER LA STAMPA DI MESSAGGI
	 * @return the console
	 */
	public IO getConsole() {
		return console;
	}

	/**
	 * METODO CHE IMPOSTA UNA CONSOLE PER LA STAMPA DI MESSAGGI
	 * @param console the console to set
	 */
	public void setConsole(IO console) {
		this.console = console;
	}
}