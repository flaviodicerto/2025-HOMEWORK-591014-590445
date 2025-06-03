package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {
	private static final String MESSAGGIO_A_CHI = "A chi devo regalarlo?...";

	private String messaggio;
	private IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			if(a!=null) {
				this.messaggio = personaggio.riceviRegalo(a, partita);
				partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
				io.mostraMessaggio(this.messaggio);
			}
			else {
				io.mostraMessaggio("L'attrezzo che vuoi regalare non è presente nella borsa");
			}
		}
		else
			io.mostraMessaggio(MESSAGGIO_A_CHI);
		
	}

}
