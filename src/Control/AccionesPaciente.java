package Control;

import Modelo.Paciente;
import Modelo.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AccionesPaciente {
    private static final Logger LOG = Logger.getLogger(AccionesPaciente.class.getCanonicalName());
	
		//CONSULTAR MEDICOS
	public ArrayList<Personal> getNombreyApellidoPer(String nombre, String apePatPer) {
		DBConnection db = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Personal> response = null;
		Connection cnn = null;
		try {
			db = new DBConnection();
			db.setDbname("medicos");
			db.setUser("root");
			db.setPassword("Tlaloc45");
			db.setDriver("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://localhost:3306/");
			db.openDB();
			cnn = db.getConnection();
			
			LOG.info("select nombre_per, appat_per from MPersonal where nombre_per = \"" + nombre +"\" "
					+ "and appat_per = \"" + apePatPer + "\"");
			stm = cnn.prepareStatement("select nombre_per, appat_per from MPersonal where nombre_per = ? and appat_per = ?");
			stm.setString(1, nombre);
			stm.setString(2, apePatPer);
			stm.execute();
			rs = stm.getResultSet();
			
			response = new ArrayList<Personal>();
			while(rs.next()) {
				Personal aux = new Personal();
				aux.setNombrePer(rs.getString(1));
				aux.setApePatPer(rs.getString(2));
				response.add(aux);
			}
			stm.close();
			rs.close();
			db.closeDB();
			return response;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Error en getNombreyApellidoPer", ex);
			return new ArrayList<Personal>();
		} finally {
			db = null;
			rs = null;
			response = null;
			cnn = null;
		}
	}

	//CONSULTAR HISTORIAL PACIENTE MIO
	public ArrayList<Paciente> getHistorialC(int nss, String nombre_pac, String appat_pac , String apmat_pac, String fechanac_pac) {
		DBConnection db = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Paciente> response = null;
		Connection cnn = null;
		try {
			db = new DBConnection();
			db.setDbname("medicos");
			db.setUser("root");
			db.setPassword("Tlaloc45");
			db.setDriver("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://localhost:3306/");
			db.openDB();
			cnn = db.getConnection();
			
			LOG.info("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac from MPaciente where nss = \"" + nss + "\"" 
					+ "and nombre_pac = \"" +nombre_pac+ "\""
					+ "and appat_pac = \"" +appat_pac + "\""
					+ "and apmat_pac =\"" + apmat_pac + "\""
					+ "and fechanac_pac = \"" + fechanac_pac +"\"");
			
			stm = cnn.prepareStatement("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac MPaciente where nss = ?"
					+ "and nombre_pac = ?");
					
			stm.setInt(1, nss);
			stm.setString(2, nombre_pac);
			stm.setString(3, appat_pac);
			stm.setString(4, apmat_pac);
			stm.setString(5, fechanac_pac);
			stm.execute();
			rs = stm.getResultSet();
			
			response = new ArrayList<Paciente>();
			while(rs.next()) {
				Paciente aux = new Paciente();
				aux.setNss(rs.getInt(1));
				aux.setNombre_pac(rs.getString(2));
				aux.setAppat_pac(rs.getString(3));
				aux.setApmat_pac(rs.getString(4));
				aux.setFechanac_pac(rs.getString(5));
				response.add(aux);
			}
			stm.close();
			rs.close();
			db.closeDB();
			return response;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Error in getHistorialC", ex);
			return new ArrayList<Paciente>();
		} finally {
			db = null;
			rs = null;
			response = null;
			cnn = null;
		}
	}

}
