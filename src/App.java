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
            System.out.println(BLUE + "6. " + RESET + "Save to File");
            System.out.println(BLUE + "7. " + RESET + "Load from File");
            System.out.println(BLUE + "0. " + RESET + "Exit");
        }
    }

    static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        Student s = new Student(students.size(), name, age, email, course, gpa);
        students.add(s);
    }

    static void viewStudents() {
        System.out.println();
        System.out.printf("%-5s | %-15s | %-5s | %-25s | %-20s | %-5s\n", "ID", "Name", "Age", "Email",
                "Course", "GPA");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------");
        for (int x = 0; x < students.size(); x++) {
            int id = students.get(x).getId();
            String name = students.get(x).getName();
            int age = students.get(x).getAge();
            String email = students.get(x).getEmail();
            String course = students.get(x).getCourse();
            double gpa = students.get(x).getGpa();
            System.out.printf("%-5s | %-15s | %-5s | %-25s | %-20s | %-5s\n", id, truncate(name, 15), age,
                    truncate(email, 25), truncate(course, 20),
                    gpa);
        }
        System.out.println();
    }

    static void updateStudent(Scanner scanner) {
        System.out.print(GREEN + "Enter ID of the student to update: " + RESET);
        int id = -1;
        try {
            id = scanner.nextInt();
            if (id < 0)
            {
                System.err.println(RED + "Please enter a valid ID next time!" + RESET);
                return ;
            }
        } catch (InputMismatchException e) {
            System.err.println(RED + "Please enter a valid ID next time!" + RESET);
        }
        if (id == -1)
            return ;
        Student s = null;
        try {
            s = students.get(id);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(RED + "student with ID: " + id + " is not available" + RESET);
            return;
        }
        scanner.nextLine();
        System.out.println(BLUE + "1. " + RESET + "Name");
        System.out.println(BLUE + "2. " + RESET + "Age");
        System.out.println(BLUE + "3. " + RESET + "Email");
        System.out.println(BLUE + "4. " + RESET + "Course");
        System.out.println(BLUE + "5. " + RESET + "GPA");
        System.out.println(BLUE + "0. " + RESET + "Exit");
        System.out.print(GREEN + "Choose the number that corresponds to the property you want to change: " + RESET);
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(RED + "Invalid input, please enter a valid number from 0 to 5" + RESET);
            return;
        } finally {
            scanner.nextLine();
        }
        switch (choice) {
            case 1:
                System.out.print("Enter the new name: ");
                String name = scanner.nextLine();
                s.setName(name);
                break;
            case 2:
                System.out.print("Enter the new age: ");
                try {
                    int age = scanner.nextInt();
                    s.setAge(age);
                } catch (InputMismatchException e) {
                    System.err.println(RED + "Please enter a valid age next time!" + RESET);
                } finally {
                    scanner.nextLine();
                }
                break;
            case 3:
                System.out.print("Enter the new email: ");
                String email = scanner.nextLine();
                s.setEmail(email);
                break;
            case 4:
                System.out.print("Enter the new course: ");
                String course = scanner.nextLine();
                s.setCourse(course);
                break;
            case 5:
                System.out.print("Enter the new GPA: ");
                try {
                    double gpa = scanner.nextDouble();
                    s.setGpa(gpa);
                } catch (InputMismatchException e) {
                    System.err.println(RED + "Please enter a valid GPA next time!" + RESET);
                } finally {
                    scanner.nextLine();
                }
                break;
            case 0:
                System.out.print(">>> Exiting Student update... <<<");
                break;
            default:
                break;
        }
    }

    static void deleteStudent(Scanner scanner) {
    }

    static void searchStudent(Scanner scanner) {

    }

    static void saveToFile() {

    }

    static void loadFromFile() {

    }

    static String truncate(String value, int maxLength) {
        if (value.length() <= maxLength)
            return value;
        return value.substring(0, maxLength - 3) + "..."; // adds ellipsis
    }

    public static void main(String args[]) {
        students = new ArrayList<Student>();
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
            System.out.print(GREEN + "Choose an option: " + RESET);
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input, please enter a valid number from 0 to 7" + RESET);
                scanner.nextLine(); // clear the invalid input
                continue; // skip to next loop iteration
            }
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudent(scanner);
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 0:
                    System.out.print(">>> Exiting program... <<<");
                    break;
                default:
                    System.out.println("Please enter a valid number from 0 to 7");
            }
        } while (choice != 0);

        scanner.close();
    }
}