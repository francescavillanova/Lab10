package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {

	private RiversDAO dao=new RiversDAO();
	private List<River> fiumi;
	
	public Model() {
		fiumi=dao.getAllRivers();
	}

	public List<River> getFiumi() {
		return fiumi;
	}
	
	public List<LocalDate> getListaDate(int id){
		return dao.getListaDate(id);
	}
	
	 public double getFlussoMedio(int id) {
		 return dao.getFlussoMedio(id);
	 }
	 
	 public List<Double> getFlussi(int id) {
		 return dao.getFlussi(id);
	 }
}


