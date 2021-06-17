package id.co.javan.news.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.util.ArrayList;

import id.co.javan.news.entity.Berita;

public class BeritaService {

    public List<Berita> getAllBerita() {
        List<Berita> listBerita = new ArrayList<Berita>();

        try {
            Connection conn = new DatabaseService().getCon();
            Statement stmt = (Statement) conn.createStatement();
            String query = "SELECT * FROM berita";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                // System.out.print("ID: " + rs.getInt("id"));
                Berita beritaInstance =  new Berita();
                beritaInstance.setId(rs.getInt("id"));
                beritaInstance.setContent(rs.getString("content"));
                beritaInstance.setJudul(rs.getString("judul"));
                beritaInstance.setPublished(rs.getInt("published"));
                beritaInstance.setCreatedBy(rs.getString("created_by"));
                beritaInstance.setSlug(rs.getString("slug"));

                listBerita.add(beritaInstance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listBerita;
    }

}
