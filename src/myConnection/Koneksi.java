 
package myConnection;
import java.sql.*;

public class Koneksi {

     public Connection getConnection() throws SQLException{
        Connection cn = null;
        try
        {
            String db = "kursusbahasa";
            String sv = "jdbc:mysql://localhost:3306/"+db;
            String driver = "com.mysql.jdbc.Driver";
            
            Class.forName(driver);
            cn = DriverManager.getConnection(sv,"root","");
            return cn;
        }
        catch (SQLException s)
        {
            System.out.println("Eksepsi SQL : "+ s.getMessage());
            return null;
        }
        catch (Exception e)
        {
            System.out.println("Eksepsi : "+ e.getMessage());
            return null;
        }
     }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
