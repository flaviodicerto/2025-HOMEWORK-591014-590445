package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class ComandoPrendi implements Comando 
	{
		String nomeAttrezzo;
		public ComandoPrendi(String parametro) {
			this.nomeAttrezzo=parametro;}	
		
		@Override
		public void setParametro(String parametro) {
			this.nomeAttrezzo=parametro;
		}

		@Override
		public void esegui(Partita partita) 
		{
			if(nomeAttrezzo==null)
				partita.getConsole().mostraMessaggio("Non c'è nessun oggetto!");
			else {
				//getAttrezzo(String nomeAttrezzo)
				//A è un VETTORE DI ATTREZZI
				if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo))
				{
					Attrezzo A=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
					partita.getGiocatore().borsa.addAttrezzo(A);
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(A);
					partita.getConsole().mostraMessaggio("Hai preso l'oggetto!");
				}
				
				else
					partita.getConsole().mostraMessaggio("Non c'è nessun oggetto con questo nome!");
				
				}
			return;
			
		}
		
	}



