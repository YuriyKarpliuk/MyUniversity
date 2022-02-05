package classes;

public class Lab {


    private Integer number;

    private String description;

    public Lab(Integer number, String description) {
        this.number = number;
        this.description = description;
    }


    @Override
    public String toString() {
        return "number=" + number +
                ", description='" + description + '\''
                ;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
