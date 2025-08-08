package day_4_task_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {

    private static final String FILE_NAME = "C:\\Shoaib\\All Projects And Programs\\Java_Project\\elevate_labs\\src\\day_4_task_4\\InterviewQuestions.txt";

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println(" === Text Based Notes Manager === ");

        while (!exit) {
            System.out.println("\nMenu : ");
            System.out.println("1. Write Note ");
            System.out.println("2. Read Notes ");
            System.out.println("3. Exit ");
            System.out.print(" Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNoted();
                    break;
                case 3:
                    exit = true;
                    System.out.println(" Exiting Notes Manager.... ");
                    break;
                default:
                    System.out.println(" Invalid choice. Try again. ");
            }
        }
        sc.close();
    }

    private static void writeNote(Scanner sc) {
        System.out.println(" Enter your note (type 'END' on a new line to finish) : ");

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("END")) {
                    break;
                }
                bw.write(line);
                bw.newLine();
            }
            System.out.println(" Note saved successfully! ");
        }
        catch (IOException e) {
            System.out.println(" Error writing note : "+ e.getMessage());
        }
    }

    private static void readNoted() {
        System.out.println("\n--- Your Notes ---");
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println(" No notes found. ");
            return;
        }

        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            boolean empty = true;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }

            if (empty) {
                System.out.println(" (No Content) ");
            }
        }
        catch (IOException e) {
            System.out.println(" Error reading notes : "+ e.getMessage());
        }
    }
}
