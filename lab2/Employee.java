public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    public Department getDepartment() {
        return this.department;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.department.getCEO() == this) {
            return this.name + " is CEO of " + this.department;
        } else
            return this.name + " is working in " + this.department + " with CEO " + this.department.getCEO().getName();
    }
}
