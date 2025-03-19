package test;

import java.sql.Connection;
import utils.DatabaseConnection;

public class TestDatabase {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Kết nối MySQL thành công!");
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
