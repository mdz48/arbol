package models;

public class Employee {
    private String name;
    private int afiliation;
    private String direction;

    public Employee(String name, int afiliation, String direction) {
        this.name = name;
        this.afiliation = afiliation;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAfiliation() {
        return afiliation;
    }

    public void setAfiliation(int afiliation) {
        this.afiliation = afiliation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", afiliation=" + afiliation +
                ", direction='" + direction + '\'' +
                '}';
    }
}
