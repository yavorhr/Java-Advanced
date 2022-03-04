package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public List<Student> students;
    public int capacity;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity && !this.students.contains(student)) {
            StringBuilder sb = new StringBuilder("Added student ");
            students.add(student);
            sb.append(student.getFirstName()).append(" ").append(student.getLastName());
            return sb.toString();
        } else if (this.students.contains(student)) {
            return "Student is already in the classroom";
        }
        return "No seats in the classroom";
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
        StringBuilder sb = new StringBuilder("Subject: ");
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                sb.append(subject).append(System.lineSeparator()).append("Students:").append(System.lineSeparator());
                sb.append(student.getFirstName()).append(" ").append(student.getLastName()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
        return "No students enrolled for the subject";

    }

    public String getStudent(String firstName, String lastName) {
        String student = "";
        for (Student currentStudent : this.students) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                student = currentStudent.toString();
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d%n", students.size()));
        for (Student student : students) {
            sb.append(String.format("==%s", student.toString())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

//o	"Classroom size: {added_students_count}
//   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
//   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
//   (…)"