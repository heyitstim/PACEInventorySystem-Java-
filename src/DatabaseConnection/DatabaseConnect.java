
package DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnect {
    
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private dbcom DBCon;
    
    public DatabaseConnect(){
        DBCon = new dbcom();
        con = DBCon.getConnection();  
    }
}
