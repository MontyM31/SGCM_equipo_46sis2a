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
 * Servlet implementation class CPaciente
 */
@WebServlet("/CPerfil")
public class CPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

       
       public void init(ServletConfig cfg) throws ServletException{
       }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Metodos metodo = null;
		ArrayList<Paciente> responseDB = null;
		
		try (PrintWriter out = response.getWriter();){
			
		int nss = Integer.parseInt(request.getParameter("nss"));
		String nombre_pac = request.getParameter("Nombre");
		String appat_pac = request.getParameter("appat");
		String apmat_pac = request.getParameter("apmat");
		String fechanac_pac = request.getParameter("ENaciemiento");
		String CURP = request.getParameter("CURP");
		String DOireccion = request.getParameter("Direccion");
		String tel_pac = request.getParameter("Telefono");
		String tipo_genero = request.getParameter("Genero");
        String user = request.getParameter("Usuario");
        String pass = request.getParameter("Password");
        String privilegio = request.getParameter("Privilegio");
        metodo = new Metodos();
		responseDB = metodo.getPerfilPaciente(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac, CURP, DOireccion, user, pass, tel_pac, tipo_genero);	
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
								+ responseDB.get(i).getFechanac_pac() +""
								+ responseDB.get(i).getCURP()+ ""
								+ responseDB.get(i).getDOireccion()+ ""
								+ responseDB.get(i).getUser()+ ""
								+ responseDB.get(i).getPass()+ ""
								+ responseDB.get(i).getTel_pac()+ ""
								+ responseDB.get(i).getTipo_genero()+ "</t1>");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
	
	
	
	
	
	
	
	
	
	