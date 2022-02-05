package classes;

public abstract class Person {


    private String firstName;

    private String lastName;

    private Integer age;

    private Integer weight;

    private Integer height;

    public Person(String firstName, String lastName, Integer age, Integer weight, Integer height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public abstract void sayInfo();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }
}
