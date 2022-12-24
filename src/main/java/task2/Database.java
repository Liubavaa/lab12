package task2;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static Database instance;
    private final Connection connection;

    @SneakyThrows
    private Database() {
        connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        String sql = "CREATE TABLE DOCUMENT" +
                "(id    integer primary key autoincrement," +
                "gscPath   text," +
                "document  text)";
        query(sql);
    }

    public static Database getInstance() {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    @SneakyThrows
    public void update(String sql){
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }

    @SneakyThrows
    public String query(String sql){
        Statement statement = connection.createStatement();
        String result = null;
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()){
            result = rs.getString("document");
        }
        rs.close();
        statement.close();
        return result;
    }
}
