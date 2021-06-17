package id.co.javan.news.services;
import java.sql.*;

public class DatabaseService {

    private Connection con = null;

    public DatabaseService() {
        String JDBCURL = "jdbc:mysql://localhost:3306/berita?autoReconnect=true&useSSL=false";
        try {
            this.con = DriverManager.getConnection(JDBCURL, "root_user", "");
            System.out.println("connection is established");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getCon() {
        return con;
    }

}
