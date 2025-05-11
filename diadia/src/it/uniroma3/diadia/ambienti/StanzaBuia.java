package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza Buia - 
 * Una stanza le quali direzioni sono visibili solo tramite
 * il piazzamento di una lanterna
 * 
 * @author 591014 - 590445 
 * @see Stanza
 * @version base
*/


public class StanzaBuia extends Stanza {
	final static private String NOME_PARTICOLARE = "lanterna";
	final static private String RISPOSTA = "Qui c'è un buio pesto";
	private String nomeAttrezzoParticolare;

    public StanzaBuia(String nome) {
        super(nome);
        this.nomeAttrezzoParticolare = NOME_PARTICOLARE;
    }
	@Override
	public String getDescrizione() {
        if(super.hasAttrezzo(this.NOME_PARTICOLARE)) {
            return super.toString();
        }
        return RISPOSTA;
    }
}
