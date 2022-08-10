
package ConectionMySQL;
import java.sql.*;

public class ConnectionProvider {
    public static Connection getCon()
   {
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection  con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/predictable","root","");
          return con;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
}
