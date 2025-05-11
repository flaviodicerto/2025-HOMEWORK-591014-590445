package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza Magica - 
 * Stanza particolare che cambia il nome dell'oggetto posizionato
 * modificandone l'ordine delle lettere in modo contrario
 * 
 * @author 591014 - 590445 
 * @see Stanza
 * @version base
*/


class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3; //valore di default per la soglia
	private int contatoreAttrezziPosati; //numero di attrezzi posat
	private int sogliaMagica; //numero di attrezzi da posare prima che si attivi il comportamento «magico» della stanza

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica) 
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito  = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}

}
