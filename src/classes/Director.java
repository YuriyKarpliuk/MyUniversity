package classes;

public class Director extends Person implements Employee {


    private Integer rating;

    public static final Integer salaryD = 30000;

    private Integer money;

    private Integer exp;


    public Director(String firstName, String lastName, Integer age, Integer weight, Integer height, Integer rating, Integer money, Integer exp) {
        super(firstName, lastName, age, weight, height);
        this.rating = rating;
        this.money = money;
        this.exp = exp;
    }

    public void signTheOrder() {
        System.out.println("\n" + this.getLastName() + " " + this.getFirstName() + " signed the order");
    }


    public void ratingInfo() {
        System.out.println("My trust rating is " + this.rating + "%");
    }


    @Override
    public void sayInfo() {
        System.out.println("Hello,I am " + this.getLastName() + " " + this.getFirstName() + " ,the director of this university");
    }


    @Override
    public void getSalary() {
        setMoney(getMoney() + salaryD);
        System.out.println("I am director of this university and I have " + this.getMoney() + " hrn.");
    }


    @Override
    public void work() {
        System.out.println("Have visited international conference.");
    }


    @Override
    public void getExperience() {
        System.out.println("I am the director of this university for " + this.exp + " years");
    }


    @Override
    public String toString() {
        return "Director{" +
                "rating=" + rating +
                ", money=" + money +
                ", exp=" + exp +
                '}';
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }
}
