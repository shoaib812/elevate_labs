package day_2;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class StudentRecordMS {

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        System.out.println(" === Student Record Management System === ");

        while (!exit) {
            out.println("\nMenu : ");
            out.println(" 1. Add Student ");
            out.println(" 2. View All Students ");
            out.println(" 3. Update Student ");
            out.println(" 4. Delete Student ");
            out.println(" 5. Exit ");

            out.print(" Enter your choice (1 - 5) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent();
                        break;
                case 2: viewStudents();
                        break;
                case 3: updateStudent();
                        break;
                case 4: deleteStudent();
                        break;
                case 5:
                    exit = true;
                    out.println(" Exiting program. ");
                    break;

                default:
                    out.println(" Invalid choice. Try again. ");
            }
        }
        scanner.close();
    }

    public static void addStudent() {
        out.print(" Enter Student ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        out.print(" Enter Student Name : ");
        String name = scanner.nextLine();

        out.print(" Enter Student Marks : ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        studentList.add(student);
        out.print(" Student added successfully !");
    }

    public static void viewStudents() {
        if(studentList.isEmpty()) {
            out.println(" No student records found. ");
        }
        else {
            out.println("\n--- Student Records ---");
            for(Student student : studentList) {
                out.println(student);
            }
        }
    }

    public static void updateStudent() {
        out.print(" Enter Student ID to update : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for(Student student : studentList) {
            if(student.getId() == id) {
                out.print(" Enter new name : ");
                String newName = scanner.nextLine();

                out.print(" Enter new marks : ");
                double newMarks = scanner.nextDouble();

                student.setName(newName);
                student.setMarks(newMarks);
                out.println(" Student record updated successfully! ");
                return;
            }
        }
        out.println(" Student with ID " +id+ " not found.");
    }

    public static void deleteStudent() {
        out.print(" Enter Student Id to delete : ");
        int id = scanner.nextInt();

        for (Student student : studentList) {
            if(student.getId() == id) {
                studentList.remove(student);
                out.println(" Student record deleted successfully!");
                return;
            }
        }
        out.println(" Student with ID " +id+ "not found.");
    }
}
