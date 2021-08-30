package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Control.AccionesPaciente;
import Modelo.Paciente;

/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

private Connection con;
private Statement set;
private ResultSet rs;
private PreparedStatement ps;

    
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
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try (PrintWriter out = response.getWriter()){
			
			
			String user, pass;
			
			user = request.getParameter("use");
			pass = request.getParameter("pass");
			
			
			try {
				String q = "SELECT user_pac, pass_pac FROM mpaciente WHERE user_pac = '"+user+"' AND pass_pac = '"+pass+"'";
				ps = con.prepareStatement(q);
				rs = ps.executeQuery();
				
				
				if(rs.next()) {
					Paciente p = new Paciente();
					p.setuser(rs.getString("user_pac"));
					p.setpass(rs.getString("pass_pac"));
				}
				System.out.println("Se encontro el usuario");
				con.close();
				
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<meta charset='utf-8'>"
	            		+"<title>Insert title here</title>"
	            	    +"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
	            	    +"<title>Hospital la Baga</title>"	            	    
	            		+"<link rel='stylesheet' href='./CSS/estilo.css'>");            
	            out.println("</head>");
	            out.println("<body class='cuerpo'>"
	                    +"<div class='Menu'>"
	                   + "<ul class='Moviemiento'><div class='Imagen'></div>"
	                        
	                            +"<a href='Index.html'>INICIO </a>"
	                                     
	                            +"<a href='NuestrosDoctores.html'>NUESTROS DOCTORES</a>"               
	                        
	                           +"<a href='QuieneSomos.html'>QUIENES SOMOS</a>"               
	                       
	                            +"<a href='Cita.html'>CITAS</a>"                
	                       
	                            +"<a href='HistorialC.html'>HISTORIAL CLINICO</a>"             
	                        
	                            +"<a href='IniciarSesion.html'>INICAR SESION</a>"
	                            
	                            +"<input type='button' value='Buscar'> <input type='text'>"
	                     		
	                    +"</ul>"
	                +"</div>"
	                    +"<div>"
	       		+"<img class='Logo' src='Imagenes/Logo.png' height='200' width='300'>"
			    +"<p>Loremipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
			    +"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
			    +"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo"
			    +"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
			    +"illum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non"
			    +"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
			    +"</div>"
			 
			    +"<div>"
	       		+"<img class='Logo' src='Imagenes/Logo.png' height='200' width='300'>"
			    +"<p>Loremipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
			    +"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
			    +"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo"
			    +"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
			    +"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non"
			    +"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
			    +"</div>"
			 
			    +"<div>"
	       		+"<img class='Logo' src='Imagenes/Logo.png' height='200' width='300'>"
			    +"<p>Loremipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
			    +"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
			    +"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo"
			    +"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
			    +"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non"
			    +"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
			    +"</div>"
	       
	       
	       +"<footer>"
	       
	       +"</footer>");
	       
            out.println("</body>");
            out.println("</html>");
				
			}catch(Exception e) {
				
				System.out.println("Error al encontrar el usuario");
				System.out.println(e.getMessage());
				
                out.println("<!DOCTYPE html>");
                out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Insert title here</title>"
	            	    +"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
	            	    +"<title>Hospital la Baga</title>"	            	    
	            		+"<link rel='stylesheet' href='./CSS/estilo.css'>");            
	            out.println("</head>");
	            out.println("<body class='cuerpo'>"
	                    +"<div class='Menu'>"
	                   + "<ul class='Moviemiento'><div class='Imagen'></div>"
	                        
	                            +"<a href='Index.html'>INICIO </a>"
	                                     
	                            +"<a href='NuestrosDoctores.html'>NUESTROS DOCTORES</a>"               
	                        
	                           +"<a href='QuieneSomos.html'>QUIENES SOMOS</a>"               
	                       
	                            +"<a href='Cita.html'>CITAS</a>"                
	                       
	                            +"<a href='HistorialC.html'>HISTORIAL CLINICO</a>"             
	                        
	                            +"<a href='IniciarSesion.html'>INICAR SESION</a>"
	                            
	                            +"<input type='button' value='Buscar'> <input type='text'>"
	                     		
	                    +"</ul>"
	                +"</div>"
                		+"<h1>Error al Iniciar sesion</h1>"
                        + "<br>");
                out.println("</body>");
                out.println("</html>");
				
			}
		}
			

			
			
			
			
		}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
