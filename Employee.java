

/**
 * Сотрудник компании.
 */
public class Employee {
    private final String name;
    private final Department department;

    /**
     * Создаёт сотрудника и автоматически добавляет его в отдел.
     *
     * @param name       имя сотрудника
     * @param department отдел, в котором работает сотрудник
     */
    public Employee(final String name,
                    final Department department)
    {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    /**
     * Возвращает отдел сотрудника.
     *
     * @return отдел
     */
    public Department getDepartment() {
        return this.department;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя
     */
    public String getName() {
        return this.name;
    }

    /**
     * Строковое представление с учётом должности CEO.
     *
     * @return строка с информацией о сотруднике
     */
    @Override
    public String toString() {
        if (this.department.getCeo() == this) {
            return this.name + " is CEO of " + this.department;
        } else {
            return this.name + " is working in "
                    + this.department + " with CEO "
                    + this.department.getCeo().getName();
        }
    }
}
