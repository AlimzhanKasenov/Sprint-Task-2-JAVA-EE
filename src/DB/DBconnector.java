package DB;

import model.Languages;
import model.News;
import model.Publications;

import java.sql.*;
import java.util.ArrayList;

public class DBconnector {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd?useUnicode=true&serverTimezone=UTC",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Languages> getLanguages() {
        ArrayList<Languages> languages = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT id, name, code FROM languages");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String n = rs.getString("name");
                String cod = rs.getString("code");
                languages.add(new Languages(id, n, cod));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("" +
                    "SELECT it.id, it.title, it.short_content, it.content, it.post_date, it.picture_url, " +
                    "it.language_id, it.publication_id, pub.id, pub.name, pub.description, pub.rating, " +
                    "lan.id, lan.name, lan.code " +
                    "FROM news it " +
                    "INNER JOIN languages lan ON it.language_id = lan.id " +
                    "INNER JOIN publications pub ON it.publication_id = pub.id");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String short_content = rs.getString("short_content");
                String content = rs.getString("content");
                Timestamp post_date = rs.getTimestamp("post_date");
                String picture_url = rs.getString("picture_url");
                Languages lan = new Languages(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("code"));
                Publications pub = new Publications(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("rating"));
                arr.add(new News(id, title, short_content, content, post_date, picture_url, lan, pub));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static ArrayList<Publications> getPublications() {
        ArrayList<Publications> publ = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT id, name, description, rating FROM publications");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double rating = rs.getDouble("rating");
                publ.add(new Publications(id, name, description, rating));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publ;
    }

    public static ArrayList<News> getSortNow(Long lan){
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("" +
                    "SELECT * FROM news " +
                    "WHERE language_id = ? " +
                    "ORDER BY post_date DESC");

            st.setLong(1, lan);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                News n = new News();
                n.setId(rs.getLong("id"));
                n.setTitle(rs.getString("title"));
                n.setShort_content(rs.getString("short_content"));
                n.setContent(rs.getString("content"));
                n.setPost_date(rs.getTimestamp("post_date"));
                n.setPicture_url(rs.getString("picture_url"));

                Languages langua = new Languages();
                langua.setId(rs.getLong("language_id"));

                Publications pub = new Publications();
                pub.setId(rs.getLong("publication_id"));

                n.setLanguage_id(langua);
                n.setPublication_id(pub);

                if (langua.getId() == lan) {
                    arr.add(n);
                }
            }
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}
