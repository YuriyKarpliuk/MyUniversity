package classes;

public class Lesson {


    private Subject subject;

    private boolean isStarted = false;

    private Integer startedTime;

    private Integer endedTime;

    public Lesson(Integer startedTime, Integer endedTime) {
        this.startedTime = startedTime;
        this.endedTime = endedTime;
    }

    public boolean startLesson() {
        if (isStarted) {
            System.out.println("The lesson is started");
            return isStarted;
        } else {
            System.out.println("The teacher is late");
            isStarted = true;
            return isStarted;
        }
    }


    public Integer getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Integer startedTime) {
        this.startedTime = startedTime;
    }


    public Integer getEndedTime() {
        return endedTime;
    }

    public void setEndedTime(Integer endedTime) {
        this.endedTime = endedTime;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
