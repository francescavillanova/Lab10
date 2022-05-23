package it.polito.tdp.rivers.model;

public class Evento implements Comparable<Evento> {
	
	private double flusso;
	private int tempo;


	public Evento(double flusso, int tempo) {
		super();
		this.flusso = flusso;
		this.tempo = tempo;
	}

	
	public double getFlusso() {
		return flusso;
	}


	public void setFlusso(double flusso) {
		this.flusso = flusso;
	}


	public int getTempo() {
		return tempo;
	}


	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	@Override
	public int compareTo(Evento o) {
		return this.tempo-o.tempo;
	}
	

}
