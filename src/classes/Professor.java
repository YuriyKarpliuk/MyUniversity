package classes;

import exception.ExamMarkIsOutOfRangeException;
import exception.ProfessorIsNotPresentException;

import java.util.List;

public class Professor extends Teacher implements Employee {


    private boolean isPresent = false;

    public static final int salaryPr = 15000;

    private List<StudentsGroup> studentsGroups;

    public Professor(String firstName, String lastName, Integer age, Integer weight, Integer height, Subject subject, List<Lesson> lessons, Integer money, Integer exp, List<StudentsGroup> studentsGroups) {
        super(firstName, lastName, age, weight, height, subject, lessons, money, exp);
        this.studentsGroups = studentsGroups;
    }


    public void sendInfoAboutStudents() {
        System.out.println(this.getLastName() + " " + this.getFirstName() + " sent information about students grades in " + this.getSubject().name());
    }

    public void sendToComission(Student student) {
        System.out.printf("%s %s, You got few points in " + this.getSubject().name() + " so I," + this.getLastName() + " " + this.getFirstName() + ", sent you to comission!!!", student.getFirstName(), student.getLastName());
        System.out.println();
    }

    public void sendToComission(Student student, int point) {
        System.out.printf("%s %s, You got %d points in " + this.getSubject().name()
                + " so I," + this.getLastName() + " " + this.getFirstName() + ", sent you to comission!!!", student.getFirstName(), student.getLastName(), point);
        System.out.println();
    }

    public void Attend() {
        System.out.println("I, " + getLastName() + " " + getFirstName() + " , am going to start lecture ");
        this.isPresent = true;
    }

    @Override
    public void getSalary() {
        setMoney(getMoney() + salaryPr);
        System.out.println("I am professor and I have " + this.getMoney() + " hrn.");
    }


    @Override
    public void rate(Student student, Integer mark) throws ExamMarkIsOutOfRangeException {
        student.setExamMark(mark);
        System.out.println(student.getLastName() + " " + student.getFirstName() + " , your exam mark in "
                + getSubject().name() + " is : " + student.getExamMark());
    }


    @Override
    public void work() throws ProfessorIsNotPresentException {
        if (isPresent) {
            System.out.println("Please take piece of paper, we are gonna to write a test");
        } else
            throw new ProfessorIsNotPresentException("Professor " + getLastName() + " " + getFirstName() + " is not present");
    }


    @Override
    public void getExperience() {
        System.out.println("I have been working in this university for " + getExp() + " years");
    }


    @Override
    public void sayInfo() {
        System.out.println("I am " + this.getLastName() + " " + this.getFirstName() +
                " , the lectorer " + " and my subject is " + this.getSubject().name());
    }


    @Override
    public String toString() {
        return "Professor{" +
                "studentsGroups=" + studentsGroups +
                '}';
    }


    public List<StudentsGroup> getStudentsGroups() {
        return studentsGroups;
    }

    public void setStudentsGroups(List<StudentsGroup> studentsGroups) {
        this.studentsGroups = studentsGroups;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
