package database;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "root";

        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 연결 성공 시 메시지 출력
            System.out.println("Database connected successfully!");

            // 자원 해제
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }
}

