package classes;

import exception.ExamMarkIsOutOfRangeException;
import exception.LabsMarkIsOutOfRangeException;

import java.util.List;

public abstract class Teacher extends Person {


    private Subject subject;

    private List<Lesson> lessons;

    private Integer money;

    private Integer exp;

    public Teacher(String firstName, String lastName, Integer age, Integer weight, Integer height, Subject subject, List<Lesson> lessons, Integer money, Integer exp) {
        super(firstName, lastName, age, weight, height);
        this.subject = subject;
        this.lessons = lessons;
        this.money = money;
        this.exp = exp;
    }

    public abstract void rate(Student student, Integer mark) throws ExamMarkIsOutOfRangeException, LabsMarkIsOutOfRangeException;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }
}
