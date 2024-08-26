package entity;

public class Employee extends Person{
    private String position;
    private String password;
    private Integer experience;
    private String departament;

    public Employee(Integer id, String name, Integer age, String telephoneNumber, String position, String password, Integer experience, String departament) {
        super(id, name, age, telephoneNumber);
        this.position = position;
        this.password = password;
        this.experience = experience;
        this.departament = departament;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", experience=" + experience +
                ", departament='" + departament + '\'' +
                "} " + super.toString()+"\n";
    }
}
