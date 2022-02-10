package classes;

import exception.LabsMarkIsOutOfRangeException;

import java.util.List;

public class Assistant extends Teacher implements Employee {

    private List<Lab> labs;
    private List<StudentsGroup> studentsGroups;
    public static final Integer salaryA = 6000;

    public Assistant(String firstName, String lastName, Integer age, Integer weight, Integer height, Subject subject, List<Lesson> lessons, Integer money, Integer exp, List<Lab> labs) {
        super(firstName, lastName, age, weight, height, subject, lessons, money, exp);
        this.labs = labs;
        this.studentsGroups = studentsGroups;
    }

    @Override
    public void getSalary() {
        setMoney(getMoney() + salaryA);
        System.out.println("I am assistant and I have " + this.getMoney() + " hrn.");
    }


    @Override
    public void work() {
       System.out.println("For homework you need to do labs:  " + labs);
    }


    @Override
    public void getExperience() {
        System.out.println("I am working in this university only " + getExp() + " years");
    }


    @Override
    public void sayInfo() {
        System.out.println("I am " + this.getLastName() + " " + this.getFirstName() +" the laboratory assistant" + " and my subject is "
                + this.getSubject().name());
    }


    @Override
    public void rate(Student student, Integer mark) throws LabsMarkIsOutOfRangeException {
        student.setLabsMark(mark);
        System.out.println(student.getLastName() + " " + student.getFirstName() + " , your labs mark in "
                + getSubject().name() + " is : " + student.getLabsMark());
    }


    @Override
    public String toString() {
        return "Assistant{" +
                "labs=" + labs +
                '}';
    }


    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }
}


