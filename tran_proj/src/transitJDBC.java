import java.sql.*;

public class transitJDBC {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASSWORD = "hitesh2801";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = connection.createStatement()) {

            //creation of the database
            String query = "CREATE DATABASE IF NOT EXISTS my_transit";
            stmt.executeUpdate(query);
            System.out.println("Database Created Successfully...");
            
            String useDb = "USE my_transit";
            stmt.executeUpdate(useDb);
            //creatin 2 tables for Buses and customer 

            String bus_table = "CREATE TABLE IF NOT EXISTS bus(id INT PRIMARY KEY, bus_number VARCHAR(50) NOT NULL, capacity INT NOT NULL, route VARCHAR(20) NOT NULL )";
            Statement stmt1 = connection.createStatement();
            stmt1.executeUpdate(bus_table);
            System.out.println("!!Bus table as been created!!");

            String customer_table = "CREATE TABLE IF NOT EXISTS customer(id INT PRIMARY KEY, name VARCHAR(50) NOT NULL, age INT NOT NULL, email VARCHAR(20) NOT NULL )";
            Statement stmt2 = connection.createStatement();
            stmt2.executeUpdate(customer_table);
            System.out.println("!!Customer table as been created!!");

            //5 data instances to bus_table
            query = "INSERT INTO bus (id,bus_number, capacity, route) VALUES (1,'401K', 42, 'YELHANKA')";
            stmt.executeUpdate(query);
            query = "INSERT INTO bus (id,bus_number, capacity, route) VALUES (2,'401M', 52, 'YESHWANTHPUR')";
            stmt.executeUpdate(query);
            query = "INSERT INTO bus (id,bus_number, capacity, route) VALUES (3,'501C', 48, 'HEBBAL')";
            stmt.executeUpdate(query);
            query = "INSERT INTO bus (id,bus_number, capacity, route) VALUES (4,'226WL', 64, 'WONDER LA')";
            stmt.executeUpdate(query);
            query = "INSERT INTO bus (id,bus_number, capacity, route) VALUES (5,'365', 28, 'MAJESTIC')";
            stmt.executeUpdate(query);
            
            //5 data instances to customer_table
            query = "INSERT INTO customer (id,name, age, email) VALUES (1,'Anupam',23, 'anupam@mail.com')";
            stmt.executeUpdate(query);
            query = "INSERT INTO customer (id,name, age, email) VALUES (2,'Dipasha',21, 'dipasha@mail.com')";
            stmt.executeUpdate(query);
            query = "INSERT INTO customer (id,name, age, email) VALUES (3,'Aryan',22, 'aryan@mail.com')";
            stmt.executeUpdate(query);
            query = "INSERT INTO customer (id,name, age, email) VALUES (4,'Bivas',24, 'bivas@mail.com')";
            stmt.executeUpdate(query);
            query = "INSERT INTO customer (id,name, age, email) VALUES (5,'Rishita',23, 'rishita@mail.com')";
            stmt.executeUpdate(query);
            
            //CRUD operations
            // Updating records
            query = "UPDATE customer SET age = 21 WHERE name = 'Bivas'";
            stmt.executeUpdate(query);

            // Deleting records
            query = "DELETE FROM bus WHERE bus_number = '365'";
            stmt.executeUpdate(query);

            // Retrieving records from books
            query = "SELECT * FROM bus";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("bus_number") + " " + rs.getInt("capacity") + " "
                        + rs.getString("route"));
            }
            System.out.println("\n|======================================================|\n");
            query = "SELECT * FROM customer";
            ResultSet cs = stmt.executeQuery(query);
            while (cs.next()) {
                System.out.println(cs.getInt("id") + " " + cs.getString("name") + " " + cs.getInt("age") + " "
                        + cs.getString("email"));
            }

            // // Closing the connection
            // con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}