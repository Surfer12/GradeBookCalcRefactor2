import java.util.Scanner;

public class GradebookCalculator {
    private String[] studentNames;
    private int[][] studentGrades;
    private double[] studentAverages;
    private int numStudents;
    private Scanner scanner;

    public GradebookCalculator() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        getNumberOfStudents();
        enterStudentNames();
        enterStudentGrades();
        calculateAverages();
        displayResults();
    }

    private void getNumberOfStudents() {
        System.out.print("Enter the number of students: ");
        numStudents = Integer.parseInt(scanner.nextLine());
        studentNames = new String[numStudents];
        studentGrades = new int[numStudents][];
        studentAverages = new double[numStudents];
    }

    private void enterStudentNames() {
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
        }
    }

    private void enterStudentGrades() {
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the number of grades for " + studentNames[i] + ": ");
            int numGrades = Integer.parseInt(scanner.nextLine());
            studentGrades[i] = new int[numGrades];
            
            for (int j = 0; j < numGrades; j++) {
                while (true) {
                    System.out.print("Enter grade " + (j + 1) + ": ");
                    try {
                        int grade = Integer.parseInt(scanner.nextLine());
                        if (grade >= 0 && grade <= 100) {
                            studentGrades[i][j] = grade;
                            break;
                        } else {
                            System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a numeric grade.");
                    }
                }
            }
        }
    }

    private void calculateAverages() {
        for (int i = 0; i < numStudents; i++) {
            int sum = 0;
            for (int grade : studentGrades[i]) {
                sum += grade;
            }
            studentAverages[i] = (double) sum / studentGrades[i].length;
        }
    }

    private void displayResults() {
        System.out.println("------------------------------");
        System.out.println("| Student | Grades | Avg |");
        System.out.println("------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("| %-7s | ", studentNames[i]);
            for (int j = 0; j < studentGrades[i].length; j++) {
                System.out.print(studentGrades[i][j]);
                if (j < studentGrades[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf(" | %.1f |\n", studentAverages[i]);
        }

        System.out.println("------------------------------");
        System.out.printf("Class Average: %.2f\n", calculateClassAverage());
    }

    private double calculateClassAverage() {
        double sum = 0;
        for (double avg : studentAverages) {
            sum += avg;
        }
        return sum / numStudents;
    }

    public static void main(String[] args) {
        UpdatedGradeBookCalculator calculator = new UpdatedGradeBookCalculator();
        calculator.run();
    }
}
