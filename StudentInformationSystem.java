import java.util.*;

class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

class Student {
    private String studentId;
    private String name;
    private String contactNumber;

    public Student(String studentId, String name, String contactNumber) {
        this.studentId = studentId;
        this.name = name;
        this.contactNumber = contactNumber;
    }
}

class Grade {
    private String courseId;
    private String studentId;
    private double score;

    public Grade(String courseId, String studentId, double score) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.score = score;
    }
}

class Notification {
    private String message;
    private Date timestamp;

    public Notification(String message) {
        this.message = message;
        this.timestamp = new Date();
    }
}

public class StudentInformationSystem {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void registerUser(String username, String password, String role) {
        users.put(username, new User(username, password, role));
    }

    public void addStudent(String studentId, String name, String contactNumber) {
        students.put(studentId, new Student(studentId, name, contactNumber));
    }

    public void addGrade(String courseId, String studentId, double score) {
        grades.add(new Grade(courseId, studentId, score));
    }

    public void sendNotification(String message) {
        notifications.add(new Notification(message));
    }

    public void interactiveMenu() {
        System.out.println("Welcome to the Student Information System!");

        while (true) {
            System.out.println("\n1. Register User\n2. Add Student\n3. Add Grade\n4. Send Notification\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    registerUser(username, password, role);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    addStudent(studentId, name, contactNumber);
                    System.out.println("Student added successfully!");
                    break;

                case 3:
                    System.out.print("Enter course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter score: ");
                    double score = scanner.nextDouble();
                    addGrade(courseId, studentId, score);
                    System.out.println("Grade added successfully!");
                    break;

                case 4:
                    System.out.print("Enter notification message: ");
                    String message = scanner.nextLine();
                    sendNotification(message);
                    System.out.println("Notification sent successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Student Information System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();
        sis.interactiveMenu();
    }
}