/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import java.sql.*;
public class dbcom {

    private Connection con;
    
    private String DBUser;
    private String DBPass;
    private String DBName;
    private String DBUrl;
    
    private void initDBCon() {
        this.DBName = "pacesinvent";
        this.DBUser = "root";
        this.DBPass = "";
        this.DBUrl = "jdbc:mysql://localhost:3306/" + this.DBName + "?useSSL=true";
    }
    
    public dbcom() {
        initDBCon();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.DBUrl, this.DBUser, this.DBPass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return this.con;
    }
}

