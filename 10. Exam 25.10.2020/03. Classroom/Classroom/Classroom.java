import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    private int capacity;
    private List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String output = "";

        if (studentIsInClassroom(student)) {
            output = "Student is already in the classroom";
        } else if (this.capacity < this.getStudentCount()) {
            output = "No seats in the classroom";
        } else {
            this.students.add(student);
            output = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }

        return output;
    }

    public String dismissStudent(Student student) {
        String output = "";

        if (!studentIsInClassroom(student)) {
            output = "Student not found";
        } else {
            this.students.remove(student);
            output = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }

        return output;
    }

    public String getSubjectInfo(String subject) {
        List<Student> filteredBySubject = students.stream().filter(s -> s.getBestSubject().equals(subject)).collect(Collectors.toList());

        if (filteredBySubject.size() == 0) {
            return "No students enrolled for the subject";
        } else {
            StringBuilder sb = new StringBuilder(String.format("Subject: %s\nStudents:\n", subject));

            filteredBySubject.forEach(s -> sb.append(String.format("%s %s\n", s.getFirstName(), s.getLastName())));
            return sb.toString();
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(s ->
                        s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .collect(Collectors.toList())
                .get(0);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Classroom size: %d\n", this.getStudentCount()));

        this.students.forEach(s ->
                sb.append(String.format("==Student: First Name= %s , Last Name= %s , Best Subject= %s\n",
                        s.getFirstName(),
                        s.getLastName(),
                        s.getBestSubject())));

        return sb.toString();
    }

    private boolean studentIsInClassroom(Student student) {
        return this.students.contains(student);
    }
}
