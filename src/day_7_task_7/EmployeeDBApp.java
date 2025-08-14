package day_7_task_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDBApp {
    private static final String URL = "jdbc:mysql://localhost:3306/elevate";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addEmployee(Connection conn, String name, String dept, double salary) throws SQLException {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, dept);
                    stmt.setDouble(3, salary);
                    stmt.executeUpdate();
                    System.out.println(" Employee added successfully!");
                }
    }

    private static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employee";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf(" ID : %d | Name : %s | Salary : %.2f\n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("department"), rs.getDouble("salary"));
            }
        }
    }

    private static void updateEmployee(Connection conn, int id, double salary) throws SQLException {
        String sql = " UPDATE employee SET salary = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, salary);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Employee salary updated!");
            }
            else {
                System.out.println(" Employee not found!");
            }
        }
    }

    private static void deleteEmployee(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("Employee deleted!");
            }
            else {
                System.out.println("Employee not found!");
            }
        }
    }

    public static void main(String[] args) {
        try (Connection connection = connection();
             Scanner sc = new Scanner(System.in)) {
            System.out.println("Connected to DB successfully!");

            while (true) {
                System.out.println("\n--- Employee Database Menu ---");
                System.out.println(" 1. Add Employee");
                System.out.println(" 2. View Employees");
                System.out.println(" 3. Update Employee Salary");
                System.out.println(" 4. Delete Employee");
                System.out.println(" 5. Exit");
                System.out.println(" Enter choice : ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print(" Enter name : ");
                        String name = sc.nextLine();
                        System.out.print(" Enter department : ");
                        String dept = sc.nextLine();
                        System.out.println(" Enter salary : ");
                        double salary = sc.nextDouble();
                        addEmployee(connection, name, dept, salary);
                        break;

                    case 2:
                        viewEmployees(connection);
                        break;

                    case 3:
                        System.out.print("Enter employee ID: ");
                        int upId = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();
                        updateEmployee(connection, upId, newSalary);
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        int delId = sc.nextInt();
                        deleteEmployee(connection, delId);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("⚠ Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(50) NOT NULL,
department VARCHAR(50) NOT NULL,
salary DOUBLE NOT NULL
);*/
