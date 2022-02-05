package classes;

import exception.ProfessorIsNotPresentException;

public interface Employee {

    void getSalary();

    void work() throws ProfessorIsNotPresentException;

    void getExperience();
}
