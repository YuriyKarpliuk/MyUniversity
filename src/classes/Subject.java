package classes;

public enum Subject {

    COMPUTER_LOGIC(7),DISCRETE_MATH(6),POLITOLOGY(4),DESIGN(3),LAW(5),PROGRAMMING(6),HISTORY(3),ENGLISH(3),HIGH_MATH(5),PHYSICS(5),UKRAINIAN_LANGUAGE(3),GERMAN(3);
    private Integer numberOfCredit;

    Subject(Integer numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    public Integer getNumberOfCredit() {
        return numberOfCredit;
    }
}
