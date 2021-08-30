package Servlett;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Repositorio.Metodos;
import Modelo.Personal;



/**
 * Servlet implementation class ConsultarPerfilPacientee
 */
@WebServlet("/ConsultarMedico")


public class ConsultarMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//vamos a crear el metodo constructor
    public void init(ServletConfig cfg) throws ServletException{}
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nombre_per = null;
			String appat_per = null;
			Metodos metodo = null;
			ArrayList<Personal> responseDB = null;
			PrintWriter out = response.getWriter();
			try {
				nombre_per = request.getParameter("nombre_per");
				appat_per = request.getParameter("appat_per");
				metodo = new Metodos();
				responseDB = metodo.getNombreyApellidoPer(nombre_per, appat_per);
				
				if(responseDB.isEmpty()) {
					response(response, "No se encontraron registros");
					out.println("<a href = \'NuestrosDoctores.html'>Regresar </a>");
				} else {
					out.println("<html>");
					out.println("<body>");
					for(int i = 0; i < responseDB.size(); i++) {
						out.println("<t1>" + responseDB.get(i).getNombrePer() + " "
									+ responseDB.get(i).getApePatPer() + "</t1>");
					}
					out.println("</body>");
					out.println("</html>");
				}
			} catch (Exception ex) {
				System.out.println("Error en la conexion");
				Logger.getLogger(ConsultarMedico.class.getCanonicalName()).log(Level.SEVERE, null, ex);
				response(response, "Ocurrio un error: " + ex.getLocalizedMessage());
			}
	}
	private void response(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
