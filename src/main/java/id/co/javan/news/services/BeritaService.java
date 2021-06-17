package id.co.javan.news.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.util.ArrayList;
import java.util.HashMap;

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
                Berita beritaInstance = new Berita();
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

    public boolean saveBerita(Berita berita) {

        try {
            Connection conn = new DatabaseService().getCon();
            Statement stmt = (Statement) conn.createStatement();
            String query = "INSERT INTO berita.berita" + "(judul, content, published, slug, created_by)" + "VALUES('"
                    + berita.getJudul() + "', '" + berita.getContent() + "', 1, '" + berita.getJudul() + "', '"
                    + berita.getCreatedBy() + "');";
            stmt.execute(query);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean publishUnpublishBerita(Berita berita) {

        try {
            Connection conn = new DatabaseService().getCon();
            Statement stmt = (Statement) conn.createStatement();
            String query = "UPDATE berita.berita" + " set published='" + (berita.getPublished() == 1 ? "0" : "1") + "'"
                    + " WHERE id = " + berita.getId() + "";

            stmt.execute(query);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean deleteBerita(Berita berita) {

        try {
            Connection conn = new DatabaseService().getCon();
            Statement stmt = (Statement) conn.createStatement();
            String query = "DELETE FROM berita.berita"
                    + " WHERE id = " + berita.getId() + "";

            stmt.execute(query);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateBerita(Berita berita) {

        try {
            Connection conn = new DatabaseService().getCon();
            Statement stmt = (Statement) conn.createStatement();
            String query = "UPDATE berita.berita" 
                    + " set judul='" + berita.getJudul()+ "', content='" + berita.getContent()+ "',created_by='" + berita.getCreatedBy()+ "'"
                    + " WHERE id = " + berita.getId() + "";

            stmt.execute(query);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public HashMap<String, Object> getBeritaHashmap(Berita berita) {

        HashMap<String, Object> mappedData = new HashMap<>();

        mappedData.put("judul", berita.getJudul());
        mappedData.put("content", berita.getContent());
        mappedData.put("created_by", berita.getCreatedBy());
        mappedData.put("id", berita.getId());

        return mappedData;
    }

}
