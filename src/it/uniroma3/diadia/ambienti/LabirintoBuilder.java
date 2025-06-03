package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
	}
	
	public LabirintoBuilder(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		this.labirinto.setStanzaCorrente(new Stanza(nomeStanza));
		this.labirinto.setUltimaStanzaAggiunta(this.labirinto.getStanzaCorrente());
		this.labirinto.getStanze().put(nomeStanza, this.labirinto.getStanzaCorrente());
		return this;
	}

	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.labirinto.setStanzaVincente(new Stanza(nomeStanza));
		this.labirinto.setUltimaStanzaAggiunta(this.labirinto.getStanzaVincente());
		this.labirinto.getStanze().put(nomeStanza, this.labirinto.getStanzaVincente());
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		this.labirinto.getUltimaStanzaAggiunta().addAttrezzo(new Attrezzo(nomeAttrezzo, peso));
		return this;
	}
	
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		if(this.labirinto.getStanze().isEmpty()) this.addStanzaIniziale(nomeStanza);
		this.labirinto.getStanze().put(nomeStanza, s);
		this.labirinto.setUltimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza) {
		Stanza s = new StanzaMagica(nomeStanza);
		this.labirinto.getStanze().put(nomeStanza, s);
		this.labirinto.setUltimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String chiave) {
		Stanza s = new StanzaBuia(nomeStanza);
		this.labirinto.getStanze().put(nomeStanza, s);
		this.labirinto.setUltimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza,String direzione, String chiave) {
		Stanza s = new StanzaBloccata(nomeStanza,direzione);
		this.labirinto.getStanze().put(nomeStanza, s);
		this.labirinto.setUltimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomeStanza,String nomeStanzaAdiacente  ,String direzione) {
		this.labirinto.getStanze().get(nomeStanza).impostaStanzaAdiacente(direzione, this.labirinto.getStanze().get(nomeStanzaAdiacente));
		return this;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}

