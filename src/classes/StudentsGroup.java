package classes;

public class StudentsGroup {


    private String nameOfGroup;

    public StudentsGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    @Override
    public String toString() {
        return "StudentsGroup{" +
                "nameOfGroup='" + nameOfGroup + '\'' +
                '}';
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }
}
