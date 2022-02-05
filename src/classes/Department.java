package classes;

import exception.StudentIsNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {


    private String departmentName;

    private List<Professor> professors;  //aggregation//

    private List<Assistant> assistants;  //aggregation//

    private List<StudentsGroup> studentsGroups;


    public Department(String departmentName, List<Professor> professors, List<Assistant> assistants, List<StudentsGroup> studentsGroups) {
        this.departmentName = departmentName;
        this.professors = new ArrayList<Professor>(professors);
        this.assistants = new ArrayList<Assistant>(assistants);
        this.studentsGroups = new ArrayList<StudentsGroup>(studentsGroups);

    }


    public void expelStudent(List<Student> students, int indexOfStudent) {
        System.out.println(students.get(indexOfStudent).getLastName() + " " + students.get(indexOfStudent).getFirstName() + " , you are expelled from our university!");
        students.remove(indexOfStudent);
    }


    public void registerNewStudent(Student student,List<Student> students) throws StudentIsNull {
        if (student == null) {
            throw new StudentIsNull("Student is null");
        } else {
            if (studentsGroups.size() > 30) {
                System.out.println("Sorry,our department is completely filled ");
                return;
            } else {
                students.add(student);
                student.applyDocs(this);
            }
        }
    }

    public void checkStudentsGrades(Professor professor) {
        professor.sendInfoAboutStudents();
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", professors=" + professors +
                ", assistants=" + assistants +
                ", studentsGroups=" + studentsGroups +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) && Objects.equals(professors, that.professors) && Objects.equals(assistants, that.assistants) && Objects.equals(studentsGroups, that.studentsGroups);
    }


    @Override
    public int hashCode() {
        return Objects.hash(departmentName, professors, assistants, studentsGroups);
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Assistant> assistants) {
        this.assistants = assistants;
    }

    public List<StudentsGroup> getStudentsGroups() {
        return studentsGroups;
    }

    public void setStudentsGroups(List<StudentsGroup> studentsGroups) {
        this.studentsGroups = studentsGroups;
    }
}

