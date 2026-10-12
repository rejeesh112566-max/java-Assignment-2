package assignment2;



import java.util.*;

public class StudentGradeManagementSystem {

    static List<String> students = new ArrayList<>();
    static Set<Integer> studentIds = new HashSet<>();
    static Map<Integer, Integer> marks = new HashMap<>();
    static Queue<Integer> evaluationQueue = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    static String getGrade(int mark) {
        if (mark >= 90) return "A+";
        else if (mark >= 80) return "A";
        else if (mark >= 70) return "B";
        else if (mark >= 60) return "C";
        else if (mark >= 50) return "D";
        else return "Fail";
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentIds.contains(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks (0-100): ");
        int mark = sc.nextInt();

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(name);
        studentIds.add(id);
        marks.put(id, mark);
        evaluationQueue.offer(id);

        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- STUDENT RESULTS ---");

        Iterator<Integer> iterator = studentIds.iterator();
        int i = 0;

        while (iterator.hasNext()) {
            int id = iterator.next();
            String name = students.get(i);
            int mark = marks.get(id);

            System.out.println(
                "ID: " + id +
                " | Name: " + name +
                " | Marks: " + mark +
                " | Grade: " + getGrade(mark)
            );

            i++;
        }
    }

    static void processNextStudent() {
        Integer id = evaluationQueue.poll();

        if (id == null) {
            System.out.println("No students waiting for evaluation!");
        } else {
            System.out.println(
                "Evaluated student ID: " + id
            );
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== STUDENT GRADE MANAGEMENT ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Process Next Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    processNextStudent();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
