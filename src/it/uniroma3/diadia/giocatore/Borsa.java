package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.*;

import diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		//this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.attrezzi = new ArrayList<Attrezzo>();
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi.add(attrezzo);
		this.numeroAttrezzi++;
		return true;
	}
	public int getPeso(){
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi)
			pesoTotale += a.getPeso();
		return pesoTotale;
	}
	
	public int getPesoMax(){
		return DEFAULT_PESO_MAX_BORSA;
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}
	public void setNumeroAttrezzi(int numeroattrezzi) {
		this.numeroAttrezzi=numeroattrezzi;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	    for (Attrezzo a : attrezzi) {
	        if (a != null && a.getNome().equals(nomeAttrezzo)) {
	            return a;
	        }
	    }
	    return null;
	}

	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	//INTRODURREI UN ORDINA SACCA,CHE SPOSTA INDIETRO GLI OGGETTI QUANDO VEDE NULL



	//Metodo che elimina un attrezzo dalla sacca tramite il suo nome, se lo rimuove lo restituisce in output
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =
				this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {

				iteratore.remove();
				return a;
			}
		}
		return null;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
	    // Creo un TreeSet con un comparatore personalizzato
	    SortedSet<Attrezzo> ordinati = new TreeSet<>(new Comparator<Attrezzo>() {
	        @Override
	        public int compare(Attrezzo a1, Attrezzo a2) {
	            int pesoCompare = Integer.compare(a1.getPeso(), a2.getPeso());
	            if (pesoCompare != 0) {
	                return pesoCompare;  // se i pesi sono diversi, ordina per peso
	            }
	            return a1.getNome().compareTo(a2.getNome()); // se uguali, ordina per nome
	        }
	    });
	   	ordinati.addAll(this.attrezzi);  // Aggiungo tutti gli attrezzi alla struttura ordinata
	    return ordinati;// Ritorno il SortedSet ordinato
	}

	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
	    attrezzi.sort((a1, a2) -> Integer.compare(a1.getPeso(), a2.getPeso()));
	    return attrezzi;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
	    SortedSet<Attrezzo> ordinati = new TreeSet<>((a1, a2) -> a1.getNome().compareTo(a2.getNome()));
	    ordinati.addAll(attrezzi);
	    return ordinati;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();

	    for (Attrezzo attrezzo : attrezzi) {
	        int peso = attrezzo.getPeso();	        
	        mappa.putIfAbsent(peso, new HashSet<>()); // Se la mappa non contiene già la chiave peso, crea un nuovo set
	        mappa.get(peso).add(attrezzo);// Aggiungi l'attrezzo al set corrispondente
	    }
	    return mappa;
	}
	
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    // Contenuto ordinato per peso [ ... ]
	    List<Attrezzo> ordinatoPerPeso = getContenutoOrdinatoPerPeso();
	    sb.append("[ ");
	    for (Attrezzo a : ordinatoPerPeso) {
	        sb.append(a.getNome()).append(", ");
	    }
	    if (!ordinatoPerPeso.isEmpty()) sb.setLength(sb.length() - 2); // rimuove ultima virgola e spazio
	    sb.append(" ]\n");

	    // Contenuto ordinato per nome ( ... )
	    SortedSet<Attrezzo> ordinatoPerNome = getContenutoOrdinatoPerNome();
	    sb.append("( ");
	    for (Attrezzo a : ordinatoPerNome) {
	        sb.append(a.getNome()).append(", ");
	    }
	    if (!ordinatoPerNome.isEmpty()) sb.setLength(sb.length() - 2);
	    sb.append(" )\n");

	    // Contenuto raggruppato per peso { ... }
	    Map<Integer, Set<Attrezzo>> raggruppatoPerPeso = getContenutoRaggruppatoPerPeso();
	    sb.append("{ ");
	    for (Map.Entry<Integer, Set<Attrezzo>> entry : raggruppatoPerPeso.entrySet()) {
	        sb.append(entry.getKey()).append(": [");
	        for (Attrezzo a : entry.getValue()) {
	            sb.append(a.getNome()).append(", ");
	        }
	        if (!entry.getValue().isEmpty()) sb.setLength(sb.length() - 2);
	        sb.append("], ");
	    }
	    if (!raggruppatoPerPeso.isEmpty()) sb.setLength(sb.length() - 2);
	    sb.append(" }");

	    return sb.toString();
	}

	
}