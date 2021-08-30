package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DBConnection {

	private String user;
    private String password;
    private String url;
    private String driver;
    private String dbname;
    private Connection connection;

    public DBConnection() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    

    // Coneccion Data Base
    public void openDB() {
        DataSource ds = null;
        try {
             //<----- Conexión por medio de Driver Manager ------>
             Class.forName(driver).newInstance();
             connection = DriverManager.getConnection(url + dbname, user, password); 

        } catch (Exception ex) {
            if(ex.getMessage().indexOf("Attempt to connect") > 0 ){
                Logger.getLogger(DBConnection.class.getName()).severe(
                        "No es posible conectar con la base de datos especificada, verificar datos de conexión");
            }else {
               Logger.getLogger(DBConnection.class.getName()).severe(ex.getMessage()); 
            }           
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ds = null;
        }

    }

    public void closeDB() {
        try {
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
	
}
