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

import Modelo.Paciente;
import Repositorio.Metodos;



/**
 * Servlet implementation class ConsultarPerfilPacientee
 */
@WebServlet("/HistorialC")


public class HistorialC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//vamos a crear el metodo constructor
    public void init(ServletConfig cfg) throws ServletException{}
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int nss;
			String nombre_pac = null;
			String appat_pac = null;
			String apmat_pac= null;
			String fechanac_pac =null;
			Metodos metodo = null;
			ArrayList<Paciente> responseDB = null;
			PrintWriter out = response.getWriter();
			try {
				nss=Integer.parseInt(request.getParameter("nss"));
				nombre_pac = request.getParameter("nombre_pa");
				appat_pac = request.getParameter("appat_pa");
				apmat_pac = request.getParameter("apmat_pa");
				fechanac_pac = request.getParameter("fechanac_pa");
				metodo = new Metodos();
				responseDB = metodo.getHistorialC(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac);
				
				if(responseDB.isEmpty()) {
					response(response, "No se encontraron registros");
				} else {
					out.println("<html>");
					out.println("<body>");
					for(int i = 0; i < responseDB.size(); i++) {
						out.println("<t1>" +responseDB.get(i).getNss() + ""
								+ responseDB.get(i).getNombre_pac() + " "
									+ responseDB.get(i).getAppat_pac() + ""
									+ responseDB.get(i).getApmat_pac()+ ""
									+ responseDB.get(i).getFechanac_pac() + "</t1>");
					}
					out.println("</body>");
					out.println("</html>");
				}
			} catch (Exception ex) {
				System.out.println("Error en la conexion");
				Logger.getLogger(HistorialC.class.getCanonicalName()).log(Level.SEVERE, null, ex);
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