package classes;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    private List <Student> students;

    public MyThread(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        for(Student student:students) {
            student.sayInfo();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
