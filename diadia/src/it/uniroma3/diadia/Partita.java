package it.uniroma3.diadia;
import diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO console;
	private boolean finita;
	
	
	public Partita(){
		this.giocatore = new Giocatore();
		this.labirinto=new Labirinto();
		this.finita = false;
		
	}
	
	public Partita(Labirinto l){
		this.giocatore=new Giocatore();
		this.labirinto=l;
		this.finita = false;
	}
	
	public Giocatore getGiocatore() {
        return this.giocatore;
    }

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
	}

	public IO getConsole() {
		return console;
	}
	
	public void setConsole(IO console) {
		this.console=console;
	}
	
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		if(giocatore!=null) {
		return finita || vinta() || (giocatore.getCFU() == 0);}
		else
			return (finita || vinta());
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
