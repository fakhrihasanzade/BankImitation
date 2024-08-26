package entity;

public class User extends Person{
    private Integer debt;
    private Integer score;
    private Integer salary;

    public User(Integer id, String name, Integer age, String telephoneNumber, Integer debt, Integer score, Integer salary) {
        super(id, name, age, telephoneNumber);
        this.debt = debt;
        this.score = score;
        this.salary = salary;
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "debt=" + debt +
                ", score=" + score +
                ", salary=" + salary +
                "} " + super.toString()+"\n";
    }
}
