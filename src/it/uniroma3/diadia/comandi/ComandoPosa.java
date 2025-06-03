package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando 
{
	String nomeAttrezzo;

	public ComandoPosa(String parametro) {
		this.nomeAttrezzo=parametro;}	
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null)
			partita.getConsole().mostraMessaggio("Non c'è nessun oggetto da posare!");
		else {
			if(partita.getGiocatore().borsa.hasAttrezzo(nomeAttrezzo))
			{
				Attrezzo A=partita.getGiocatore().borsa.getAttrezzo(nomeAttrezzo);
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(A);
				partita.getGiocatore().borsa.removeAttrezzo(A.getNome());
				partita.getConsole().mostraMessaggio("Hai posato l'oggetto!");
			}

			else
				partita.getConsole().mostraMessaggio("Non c'è nessun oggetto con questo nome!");
		}
		return;
	}

	

	

}
