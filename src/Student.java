import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;
    private double average;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
