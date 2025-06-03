package it.uniroma3.diadia.ambienti;

import java.util.Comparator;

public class ComparatoreStanzePerNumeroAttrezzi implements Comparator<Stanza>{

	@Override
	public int compare(Stanza o1, Stanza o2) {
		if(o1.getNumeroAttrezzi() > o2.getNumeroAttrezzi()) {
			return 1;
		}
		if(o1.getNumeroAttrezzi() < o2.getNumeroAttrezzi()) {
			return -1;
		}
		return 0;
	}

}
