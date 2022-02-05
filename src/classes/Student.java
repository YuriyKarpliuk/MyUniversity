package classes;

import exception.ExamMarkIsOutOfRangeException;
import exception.LabsMarkIsOutOfRangeException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person implements Attendance, Study {

    private Integer yearOfStudying;

    private boolean isApplied = false;

    private boolean isPresent;

    private List<Subject> subjects;

    private Integer abscence;

    private Integer examMark;

    private Integer labsMark;

    public Student(String firstName, String lastName, Integer age, Integer weight, Integer height, Integer yearOfStudying, Integer abscence, boolean isPresent, List<Subject> subjects) {
        super(firstName, lastName, age, weight, height);
        this.yearOfStudying = yearOfStudying;
        this.abscence = abscence;
        this.isPresent = isPresent;
        this.subjects = new ArrayList<Subject>(subjects);
    }


    public boolean applyDocs(Department department) {
        if (this.isApplied) {
            System.out.println("This student is already applied.");
            return this.isApplied;
        }
        isApplied = true;
        System.out.println(this.getLastName() + " " + this.getFirstName() + " is applied to " + department.getDepartmentName());
        return this.isApplied;
    }

    public void mySubjects() {
        System.out.println("My subjects :");
        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println("Name of subject : " + subject.name() + " | " + "amount of credit " + subject.getNumberOfCredit());
        }
    }


    @Override
    public void sayInfo() {
        System.out.printf("My first name is %s \nMy last name is %s \nI am %d years old \nMy weight is %d \nMy height is %d \nI am %d-year student  ", this.getFirstName(), this.getLastName(), this.getAge(), this.getWeight(), this.getHeight(), this.getYearOfStudying());
    }


    @Override
    public void getAttendance() {
        if (isPresent) {
            setAbscence(getAbscence());
        } else {
            setAbscence(getAbscence() + 1);
        }
        System.out.println("I have " + getAbscence() + " absences.");
    }


    @Override
    public boolean Attend() {
        if (isPresent) {
            System.out.println("I am present!");
            return isPresent;
        } else {
            System.out.println("I am absent!");
            return isPresent;
        }
    }


    public void setExamMark(int examMark) throws ExamMarkIsOutOfRangeException {
        if ((examMark > 60) || (examMark < 0)) {
            throw new ExamMarkIsOutOfRangeException("examMark is out of range ");
        } else {
            this.examMark = examMark;
        }
    }

    public Integer getLabsMark() {
        return labsMark;
    }

    public void setLabsMark(int labsMark) throws LabsMarkIsOutOfRangeException {
        if ((labsMark > 40) || (labsMark < 0)) {
            throw new LabsMarkIsOutOfRangeException("Error!!!Check if you set a correct mark! ");
        } else {
            this.labsMark = labsMark;
        }
    }


    @Override
    public void doHomework(Subject subject) {
        System.out.println("I am doing my homework in " + subject.name());
    }


    @Override
    public void askQuestion(Subject subject) {
        System.out.println("Ask some question about  " + subject.name());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return isApplied == student.isApplied && isPresent == student.isPresent && Objects.equals(yearOfStudying, student.yearOfStudying) && Objects.equals(subjects, student.subjects) && Objects.equals(abscence, student.abscence) && Objects.equals(examMark, student.examMark) && Objects.equals(labsMark, student.labsMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfStudying, isApplied, isPresent, subjects, abscence, examMark, labsMark);
    }


    @Override
    public String toString() {
        return "Student{" +
                "yearOfStudying=" + yearOfStudying +
                ", isApplied=" + isApplied +
                ", isPresent=" + isPresent +
                ", subjects=" + subjects +
                ", abscence=" + abscence +
                ", examMark=" + examMark +
                ", labsMark=" + labsMark +
                '}';
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Integer getAbscence() {
        return abscence;
    }

    public void setAbscence(Integer abscence) {
        this.abscence = abscence;
    }

    public Integer getYearOfStudying() {
        return yearOfStudying;
    }

    public void setYearOfStudying(Integer yearOfStudying) {
        this.yearOfStudying = yearOfStudying;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Integer getExamMark() {
        return examMark;
    }
}

