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

    public static ArrayList<Languages> gerLanguages() {
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

    public static ArrayList<News> gerNews() {
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("" +
                    "SELECT it.id, it.title, it.short_content, it.content, it.post_date, it.picture_url, " +
                    "it.language_id, it.publication_id, pub.id, pub.name, pub.description, pub.rating, " +
                    "lan.id, lan.name, lan.code " +
                    "FROM news it " +
                    "INNER JOIN languages lan it.language_id=lan.id " +
                    "INNER JOIN publications pub it.publication_id = pub.id");
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
}
