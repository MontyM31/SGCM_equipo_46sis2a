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

}
