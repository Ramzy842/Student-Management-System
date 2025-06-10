import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    static ArrayList<Student> students;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";

    static class Menu {
        public static void print() {
            System.out.println(BLUE + "Welcome to Student Management System");
            System.out.println("------------------------------------" + RESET);
            System.out.println(BLUE + "1. " + RESET + "Add Student");
            System.out.println(BLUE + "2. " + RESET + "View All Students");
            System.out.println(BLUE + "3. " + RESET + "Update Student");
            System.out.println(BLUE + "4. " + RESET + "Delete Student");
            System.out.println(BLUE + "5. " + RESET + "Search Student");
            System.out.println(BLUE + "0. " + RESET + "Exit");
        }
    }
    public static void main(String args[]) {
        students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            Menu.print();
            System.out.print(GREEN + "Choose an option: " + RESET);
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input, please enter a valid number from 0 to 5" + RESET);
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    StudentManager.addStudent(scanner, students);
                    break;
                case 2:
                    StudentManager.viewStudents(students);
                    break;
                case 3:
                    StudentManager.updateStudent(scanner, students);
                    break;
                case 4:
                    StudentManager.deleteStudent(scanner, students);
                    break;
                case 5:
                    StudentManager.searchStudent(scanner, students);
                    break;
                case 0:
                    System.out.print(">>> Exiting program... <<<");
                    break;
                default:
                    System.out.println("Please enter a valid number from 0 to 5");
            }
        } while (choice != 0);
        scanner.close();
    }
}