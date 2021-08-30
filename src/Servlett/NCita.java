package Servlett;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CPaciente
 */
@WebServlet("/NCita")
public class NCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NCita() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
    private java.sql.Connection con;
	private Statement set;
	private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        //el constructor nos va ayudar a conectarnos con l bd
        
        String url = "jdbc:mysql:3306//localhost/medicos";
                    //tipodriver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "Tlaloc45";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            url = "jdbc:mysql://localhost/medicos";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion Exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no Exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		try (PrintWriter out = response.getWriter()){
		String q;
		int nss =  Integer.parseInt(request.getParameter("nss"));
		String fecha_cita = request.getParameter("Fecha"); 
		String hora_cita = request.getParameter("Hora");

		try {
			
			
			q = "insert into mcita"
					+ "(id_cita, fecha_cita, hora_cita)"
					+ "values"
					+ "('"+nss+"','"+fecha_cita+"','"+hora_cita+"')";
			set.executeUpdate(q);
		
			 out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title></title>");            
	            out.println("</head>");
	            out.println("<body>"
	            		+"<header>"
	                    +"<div class='Menu'>"
	                    +"<ul class='Moviemiento'>"    
	                    +"<a href='Index.html'>INICIO</a>"
	                    
	                    +"<a href='NuestrosDoctores.html'>NUESTROS DOCTORES</a>"
	                    
	                    +"<a href=''>QUIENES SOMOS</a>"        
	                    
	                    +"<a href='Cita'>CITAS</a>"         
	                    
	                    +"<a href='Registrarse.html'>REGISTRARSE</a>"  
	                    
	                    +"<a href='CPerfil.html'>INICAR SESION</a>"
	                    
                     +"<input type='button' value='Buscar'> <input type='text'>"
                     
	                    +"</ul>"
	                    +"</div>"
	                    +"</header>"
	            		+"<div>"
	            	    +"<img src='Imagenes/Logo.png'>"
	            	    +"<h1>Registro Exitoso</h1>"
	            	    +"</div>");
	            out.println("</body>");
	            out.println("</html>");
			
		}catch(Exception e) {		
			System.out.println("Error al registrar en la tabla");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
			
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro</title>");            
            out.println("</head>");
            out.println("<body>"
            		+"<h1>Registro No Encontrado</h1>"
                    + "<br>");
            out.println("</body>");
            out.println("</html>");
}
		}
		}
}