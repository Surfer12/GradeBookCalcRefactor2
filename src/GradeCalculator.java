import java.util.List;

public class GradeCalculator {
    public void calculateAverages(List<Student> students) {
        for (Student student : students) {
            double average = student.getGrades().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            student.setAverage(average);
        }
    }

    public double calculateClassAverage(List<Student> students) {
        return students.stream()
                .mapToDouble(Student::getAverage)
                .average()
                .orElse(0.0);
    }
}
