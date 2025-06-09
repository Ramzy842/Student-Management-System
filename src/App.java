import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static class Menu {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";

        public static void print() {
            System.out.println(BLUE + "Welcome to Student Management System");
            System.out.println("------------------------------------" + RESET);
            System.out.println(BLUE + "1. " + RESET + "Add Student");
            System.out.println(BLUE + "2. " + RESET + "View All Students");
            System.out.println(BLUE + "3. " + RESET + "Update Student");
            System.out.println(BLUE + "4. " + RESET + "Delete Student");
            System.out.println(BLUE + "5. " + RESET + "Search Student");
            System.out.println(BLUE + "6. " + RESET + "Save to File");
            System.out.println(BLUE + "7. " + RESET + "Load from File");
            System.out.println(BLUE + "0. " + RESET + "Exit");
        }
    }

    public static void main(String args[]) {
        // Build the menu
        // init an array of students
        // When user chooses an option, respond with correct response
        // 1. ADD STUDENT ===> Prompt the user to enter the name, age, email, course and
        // gpa ===> save the student object to an array of student
        // 2. VIEW ALL STUDENTS ===> Loop through students array and print each student
        // info
        // 3. UPDATE STUDENT ===> prompt the user to enter the id of the student to
        // update ===> give the user options of what to change (print a list of student
        // attributes to choose from)
        // ===> if user chooses option "course", take the input and apply the changes to
        // student
        // 4. DELETE STUDENT ===> prompt the user to enter the id of the student to
        // delete ===> delete the student with the entered id
        // 5. SEARCH STUDENT ===> prompt the user to enter the id of the student to
        // search for ===> display the chosen student
        // 6. SAVE TO FILE ===> Save students list to a dedicated file Students.json
        // 7. LOAD FROM FILE ===> App reads 'students.json' and fills the student array
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            Menu.print();
            System.out.print("Choose an option: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a valid number from 0 to 7");
                scanner.nextLine(); // clear the invalid input
                continue; // skip to next loop iteration
            }
            switch (choice) {
                case 1:
                    System.out.print(">>> ADD STUDENT <<<");
                    break;
                case 2:
                    System.out.print(">>> VIEW ALL STUDENTS <<<");
                    break;
                case 3:
                    System.out.print(">>> UPDATE STUDENT <<<");
                    break;
                case 4:
                    System.out.print(">>> DELETE STUDENT <<<");
                    break;
                case 5:
                    System.out.print(">>> SEARCH STUDENT <<<");
                    break;
                case 6:
                    System.out.print(">>> SAVE TO FILE <<<");
                    break;
                case 7:
                    System.out.print(">>> LOAD FROM FILE <<<");
                    break;
                case 0:
                    System.out.print(">>> Exiting program... <<<");
                    break;
                default:
                    System.out.println("Please enter a valid number from 0 to 7");
                }
            System.err.println();
        } while (choice != 0);

        scanner.close();
    }
}