package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe Stanza Bloccata - 
 * Una stanza accessibile solo tramite una chiave
 * 
 * @author 591014 - 590445 
 * @see Stanza
 * @version base
*/

public class StanzaBloccata extends Stanza {
	final static private String NOME_PARTICOLARE = "passpartout";
	private String direzioneBloccata;
	private String nomeAttrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata) {
        super(nome);
        this.nomeAttrezzoSbloccante = NOME_PARTICOLARE;
        this.direzioneBloccata = direzioneBloccata;
    }
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(nomeAttrezzoSbloccante)) {
            return super.getDescrizione();
        }
        StringBuilder risultato = new StringBuilder();
        risultato.append(super.getNome());
        risultato.append("\n-> DIREZIONE "+this.direzioneBloccata+" BLOCCATA <-");
        risultato.append("\nUscite: ");
        for (String direzione : super.getDirezioni())
            if (direzione!=null)
                risultato.append(" " + direzione);
        risultato.append("\nAttrezzi nella stanza: ");
        for (Attrezzo attrezzo : super.getAttrezzi()) {
            if (attrezzo != null)
                risultato.append(attrezzo.toString() + " ");
        }
        return risultato.toString();
    }
	
	@Override
    public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
        if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
            stanza = this;
        }
        else {
            stanza = super.getStanzaAdiacente(direzione);
        }
        return stanza;
    }
}
