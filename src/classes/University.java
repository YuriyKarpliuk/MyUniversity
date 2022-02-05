package classes;

import java.util.HashSet;
import java.util.Set;

public class University {


    private String universityName;

    private String universityAddress;

    private Director director; //composition//

    private Set<Department> departments; //composition//

    public University(String universityName, String universityAddress, Director director, Set<Department> departments) {
        this.universityName = universityName;
        this.universityAddress = universityAddress;
        this.director = director;
        this.departments = new HashSet<Department>(departments);
    }


    public void makeAnnouncement(Director director) {
        director.signTheOrder();
        System.out.println("Our university will study online during this semester.");
    }


    public void infoAboutUni() {
        System.out.printf("\nHello from %s \nOur address is %s", this.getUniversityName(), this.getUniversityAddress());
        System.out.println();
    }

    public Director getDirector() {
        return director;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
