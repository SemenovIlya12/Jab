import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Подразделение компании.
 */
public class Department {
    private final String name;
    private final List<Employee> employees = new ArrayList<>();
    private Employee ceo;

    /**
     * Создаёт подразделение с заданным именем.
     *
     * @param name название подразделения
     */
    public Department(final String name) {
        this.name = name;
    }

    /**
     * Назначает генерального директора.
     *
     * @param ceo назначаемый сотрудник подразделения
     */
    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

    /**
     * Возвращает текущего генерального директора.
     *
     * @return CEO подразделения или null
     */
    public Employee getCeo() {
        return this.ceo;
    }

    /**
     * Возвращает неизменяемый список сотрудников.
     *
     * @return копия списка сотрудников
     */
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(this.employees);
    }

    /**
     * Добавляет сотрудника в подразделение.
     *
     * @param employee новый сотрудник
     */
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    /**
     * Увольняет сотрудника.
     *
     * @param employee увольняемый сотрудник
     */
    public void fire(Employee employee) {
        this.employees.remove(employee);
    }

    /**
     * Возвращает название подразделения.
     *
     * @return название
     */
    @Override
    public String toString() {
        return this.name;
    }
}
