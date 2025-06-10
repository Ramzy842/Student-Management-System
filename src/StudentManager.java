import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
    static String truncate(String value, int maxLength) {
        if (value.length() <= maxLength)
            return value;
        return value.substring(0, maxLength - 3) + "...";
    }

    static void printStudentTableHeader() {
        System.out.println();
        System.out.printf("%-5s | %-15s | %-5s | %-25s | %-20s | %-5s\n", "ID", "Name", "Age", "Email",
                "Course", "GPA");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------");
    }

    static void addStudent(Scanner scanner, ArrayList<Student> students) {
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

    static void viewStudents(ArrayList<Student> students) {
        if (students.size() == 0) {
            System.err.println(App.RED + "No students available" + App.RESET);
            return;
        }
        printStudentTableHeader();
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

    static void updateStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print(App.GREEN + "Enter ID of the student to update: " + App.RESET);
        int id = -1;
        try {
            id = scanner.nextInt();
            if (id < 0) {
                System.err.println(App.RED + "Please enter a valid ID next time!" + App.RESET);
                return;
            }
        } catch (InputMismatchException e) {
            System.err.println(App.RED + "Please enter a valid ID next time!" + App.RESET);
        }
        if (id == -1)
            return;
        Student s = null;
        try {
            s = students.get(id);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(App.RED + "student with ID: " + id + " is not available" + App.RESET);
            return;
        }
        scanner.nextLine();
        System.out.println(App.BLUE + "1. " + App.RESET + "Name");
        System.out.println(App.BLUE + "2. " + App.RESET + "Age");
        System.out.println(App.BLUE + "3. " + App.RESET + "Email");
        System.out.println(App.BLUE + "4. " + App.RESET + "Course");
        System.out.println(App.BLUE + "5. " + App.RESET + "GPA");
        System.out.println(App.BLUE + "0. " + App.RESET + "Exit");
        System.out.print(
                App.GREEN + "Choose the number that corresponds to the property you want to change: " + App.RESET);
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(App.RED + "Invalid input, please enter a valid number from 0 to 5" + App.RESET);
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
                    System.err.println(App.RED + "Please enter a valid age next time!" + App.RESET);
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
                    System.err.println(App.RED + "Please enter a valid GPA next time!" + App.RESET);
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

    static void deleteStudent(Scanner scanner, ArrayList<Student> students) {
        try {
            System.out.print(App.GREEN + "Enter the ID of the student you wish to delete: " + App.RESET);
            int id = -1;
            try {
                id = scanner.nextInt();
                students.remove(id);
                System.out.print(App.GREEN + "You successfully removed the student with ID: " + id + App.RESET);
                for (int x = 0; x < students.size(); x++) {
                    students.get(x).setId(x);
                }
                System.out.println();
            } catch (IndexOutOfBoundsException e) {
                System.err.println(App.RED + "student with ID: " + id + " is not available" + App.RESET);
                scanner.nextLine();
                return;
            }
        } catch (InputMismatchException e) {
            System.err.println(App.RED + "Please enter a valid ID next time!" + App.RESET);
        }
        scanner.nextLine();
    }

    static void searchStudent(Scanner scanner, ArrayList<Student> students) {
        try {
            System.out.print(App.GREEN + "Enter the ID of the student you wish to search for: " + App.RESET);
            int _id = -1;
            try {
                _id = scanner.nextInt();
                int id = students.get(_id).getId();
                printStudentTableHeader();
                String name = students.get(_id).getName();
                int age = students.get(_id).getAge();
                String email = students.get(_id).getEmail();
                String course = students.get(_id).getCourse();
                double gpa = students.get(_id).getGpa();
                System.out.printf("%-5s | %-15s | %-5s | %-25s | %-20s | %-5s\n", id, truncate(name, 15), age,
                        truncate(email, 25), truncate(course, 20),
                        gpa);

                System.out.println();
            } catch (IndexOutOfBoundsException e) {
                System.err.println(App.RED + "student with ID: " + _id + " is not available" + App.RESET);
                scanner.nextLine();
                return;
            }
        } catch (InputMismatchException e) {
            System.err.println(App.RED + "Please enter a valid ID next time!" + App.RESET);
        }
        scanner.nextLine();
    }
}
