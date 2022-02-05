package classes;

import java.util.List;

public class MyRunnable implements Runnable {
    private List<Professor> professors;

    public MyRunnable(List<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public void run() {
        for(Professor professor:professors) {
            professor.getSalary();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
