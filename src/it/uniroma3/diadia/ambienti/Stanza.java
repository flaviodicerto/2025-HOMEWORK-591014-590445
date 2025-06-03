package it.uniroma3.diadia.ambienti;
import java.util.*;

import diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author 591014 - 590445 
 * @see Attrezzo
 * @version base
 */

public class Stanza implements Comparable<Stanza>{

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;
	private List<Attrezzo> attrezzi;

	private Map<String,Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	/*
     public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new new HashMap<>();
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.uscite = 
        this.attrezzi = new ArrayList<>();
    } */

	public Stanza(String nome){
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<>();
		this.nome = nome;
	}


	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}


	public void impostaStanzaAdiacente(String direzione,Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {	
		return this.nome;
	}



	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public int getNumeroAttrezzi() {
		return attrezzi.size();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (!this.attrezzi.contains(attrezzo)) {
			this.attrezzi.add(attrezzo);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
	    StringBuilder risultato = new StringBuilder();
	    risultato.append(this.nome);
	    risultato.append("\nUscite: ");
	    for (String direzione : this.stanzeAdiacenti.keySet()) {
	        risultato.append(" " + direzione);
	    }
	    risultato.append("\nAttrezzi nella stanza: ");
	    for (Attrezzo attrezzo : this.attrezzi) {
	        if (attrezzo != null)
	            risultato.append(attrezzo.toString() + " ");
	    }
	    return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				return attrezzo;
		}
		return null;  
	}
	
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza s=(Stanza)o;
		if(s.getNome().equals(this.nome))
			return true;
		return false;
	}
	
	public int compareTo(Stanza s) {
		if(this.getNumeroAttrezzi()>s.getNumeroAttrezzi()) {
			return 1;
		}
		if(this.getNumeroAttrezzi()<s.getNumeroAttrezzi()) {
			return -1;
		}
		return 0;
	}


	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
	    if (attrezzo == null) 
	    	return false;
	    return this.attrezzi.remove(attrezzo);
	}

	/**
	 * @return IL PERSONAGGIO
	 */
	public AbstractPersonaggio getPersonaggio() {
		return personaggio;
	}

	/**
	 * @param IL PERSONAGGIO DA SETTARE
	 */
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}

	public String[] getDirezioni() {
	    return this.stanzeAdiacenti.keySet().toArray(new String[0]);
	}

}