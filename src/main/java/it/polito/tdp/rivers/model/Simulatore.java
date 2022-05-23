package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.Graphs;


public class Simulatore {

	//Coda degli eventi
		private PriorityQueue<Evento> queue;
		
		//Parametri di simulazione
		private double Q;
		private double fMed; 
		private List<Double> listaFlussi;
		
		//Output della simulazione 
		private int giorni;
		private double Cmed;		
		
		//Stato del mondo simulato
		private double C;
		
		
		public Simulatore(double fMed, List<Double> listaFlussi) {
		   this.fMed=fMed;
		   this.listaFlussi=listaFlussi;
		}
		
		public void init(double k) {	
			this.Q=this.fMed*k*30*86400;
			this.C=Q/2;
			
			this.queue=new PriorityQueue<>();
			this.queue.add(new Evento(listaFlussi.get(0), 1));
		}
		
		public void run() {
			while(!this.queue.isEmpty()) {  
				Evento e=this.queue.poll();  
				processEvent(e);  
			}
		}

		private void processEvent(Evento e) {
			double entrata=e.getFlusso();
			double uscita=0.8*fMed*86400;
			double entrataEffettiva;
			
			if(entrata>uscita) {
				entrataEffettiva=entrata-uscita;
				this.C=C+entrataEffettiva-uscita;
			} else {
				entrataEffettiva=entrata;
				this.C=C+entrataEffettiva-uscita;
			}
		
			if(this.C > this.Q) {
				
			}
		
			int confinanti=this.grafo.degreeOf(e.getNazione()); //numero di nazioni confinanti
			int gruppiMigranti=migranti / confinanti; 
			stanziali+= migranti % confinanti; //agli stanziali devo aggiungere il resto della divisione 
			
			//Aggiorno lo stato del mondo (non c'è lo switch perchè esiste un solo tipo di eventi)
			this.persone.put(e.getNazione(), this.persone.get(e.getNazione())+stanziali);  //aggiungo al numero di persone di quello stato quelle che arrivano
			this.nPassi=e.getTime();
			
			//Predispongo gli eventi futuri
			if(gruppiMigranti!=0) {
				for(Country vicino: Graphs.neighborListOf(this.grafo, e.getNazione())){
					this.queue.add(new Evento(e.getTime()+1, vicino, gruppiMigranti));
				}
			}
}
