package it.uniroma3.diadia.comandi;

import diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  591014 - 590445 
 * @version base
 */

public interface Comando {

	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);

	/**
	 * set parametro del comando
	 */
	public void setParametro(String parametro);
	
}
