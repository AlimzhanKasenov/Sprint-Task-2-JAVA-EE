package DB;

import model.Languages;
import model.News;
import model.Publications;
import model.Users;

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

    public static ArrayList<News> getNewsByLanguageId(Long langId) {
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("" +
                    "SELECT it.id, it.title, it.short_content, it.content, it.post_date, it.picture_url, " +
                    "it.language_id, it.publication_id, pub.id, pub.name, pub.description, pub.rating, " +
                    "lan.id, lan.name, lan.code " +
                    "FROM news it " +
                    "INNER JOIN languages lan ON it.language_id = lan.id " +
                    "INNER JOIN publications pub ON it.publication_id = pub.id " +
                    "WHERE it.language_id = ?");

            st.setLong(1, langId);
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

    public static ArrayList<News> getOneNov(Long id_news) {
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
                if (id == id_news) {
                    arr.add(new News(id, title, short_content, content, post_date, picture_url, lan, pub));
                }
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static boolean addUser(String login, String password, String name) {
        int rows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO users (id, login, password, name) " +
                    "values (null, ?, ?, ?)");

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            rows = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean getUserVerification(String s) {
        boolean b = false;
        try {
            PreparedStatement st = connection.prepareStatement("" +
                    "SELECT id, login, password, name FROM users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                if (login.equals(s))
                    b = true;
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean addLanguages(String name, String code) {
        boolean b = false;
        int row = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO languages (id, name, code) " +
                    "values (null, ?, ?)");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, code);
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (row > 0)
            b = true;
        return b;
    }

    public static void editLanguages(Languages language) {

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE languages SET name = ?, code = ? " +
                    "WHERE id = ?");

            statement.setString(1, language.getName());
            statement.setString(2, language.getCode());
            statement.setLong(3, language.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Languages getOneLanguages(Long lang_id) {
        Languages languages = new Languages();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT id, name, code FROM languages");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                if (id == lang_id) {
                    languages = new Languages(id, name, code);
                }
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    public static void deleteLanguages(Long lan){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM languages WHERE id = ?");

            statement.setLong(1, lan);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Users getOneUser(String login, String password) {
        Users user = new Users();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, login, password, name FROM users");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String loginUser = rs.getString("login");
                String passwordUser = rs.getString("password");
                String fullName = rs.getString("name");
                if (login.equals(loginUser) & password.equals(passwordUser)) {
                    user.setId(id);
                    user.setLogin(loginUser);
                    user.setPassword(passwordUser);
                    user.setName(fullName);
                    break;
                }
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}