package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
    public List<LocalDate> getListaDate(int id) {
		
		final String sql = "SELECT day "
				+ "FROM flow "
				+ "WHERE river=? "
				+ "ORDER BY DAY";

		List<LocalDate> listaDate = new LinkedList<LocalDate>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				listaDate.add(res.getDate("day").toLocalDate());
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return listaDate;
	}
    
    public double getFlussoMedio(int id) {
		
		final String sql = "SELECT AVG(flow) AS media "
				+ "FROM flow "
				+ "WHERE river=?";
			

		double flussoMedio;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();

			res.first();
			flussoMedio=res.getDouble("media");
			

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return flussoMedio;
	}
    
    public List<Double> getFlussi(int id) {
		
		final String sql = "SELECT flow "
				+ "FROM flow "
				+ "WHERE river=? "
				+ "ORDER BY day";
			

		List<Double> listaFlussi = new LinkedList<Double>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				listaFlussi.add(res.getDouble("flow"));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return listaFlussi;
	}
}
