import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private Employee ceo;

    public Department(String name) {
        this.name = name;
    }

    public void setCEO(Employee e) {
        if (e == null) throw new IllegalArgumentException("CEO не может быть null");
        this.ceo = e;
    }

    public Employee getCEO() {
        return this.ceo;
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void removeEmployee(Employee e) {
        employees.remove(e);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
