
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    //incorporamos la libreria
  private static String driver = "com.mysql.jdbc.Driver";  
   //nombre de la base de datos
  private static String database = "trasefor";
  //URL servidor de Mysql
  private static String hostname  = "127.0.0.1";
  //numero de puerto de conexion
  private static String port = "3306";
  //usuario de la base de datos
  private static String username = "root";
  //clave de usuario de la base de datos
  private static String password = "123456789";
  //URL de conexion final
  private static String connectionURL;
  //conector
  private static Connection conn;
  
  public ConexionMySQL(){
      this.connectionURL = "jdbc:mysql://";
      this.connectionURL += hostname + ":" + port + "/" + database;
      this.connectionURL += "?autoReconnect=tru&useSSL=false";
  }
  
  public static Connection getConnection(){
      try {
          Class.forName(driver);
      try {
          conn = DriverManager.getConnection(connectionURL,username,password);    
      } catch(SQLException e){
          System.out.print("no se puede conectar: "+e.getMessage());
      }   
      }catch (ClassNotFoundException ex){
          System.out.print("la clave"+driver+"no existe en el sistema");
      }
      return conn;
  }
  
  
  
  
  
}
