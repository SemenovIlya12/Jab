import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Главный класс (entrypoint)
 */
public class Main {

    private static final int DEFAULT_CHOICE = -1;

    /**
     * Точка входа.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter task number: !");

        try {
            final int taskid = scanner.nextInt();
            scanner.nextLine();

            switch (taskid) {
                case 1:
                    executeTask1(scanner);
                    break;
                case 2:
                    executeTask2(scanner);
                    break;
                case 3:
                    executeTask3(scanner);
                    break;
                case 4:
                    executeTask4(scanner);
                    break;
                case 5:
                    executeTask5(scanner);
                    break;
                default:
                    System.out.println("Задания с таким " +
                            "номером нет.");
            }
        } catch (InputMismatchException e) {
                System.out.println(
                    "Ошибка: введите целое число.");
            }
        }
    // задание 1 – создание трёх людей
    private static void executeTask1(final Scanner scanner) {
        System.out.print("Введите имя первого человека: ");
        final String name1 = scanner.nextLine();
        System.out.print("Введите рост первого человека: ");
        final int height1 = readInt(scanner);

        System.out.print("Введите имя второго человека: ");
        final String name2 = scanner.nextLine();
        System.out.print("Введите рост второго человека: ");
        final int height2 = readInt(scanner);

        System.out.print("Введите имя третьего человека: ");
        final String name3 = scanner.nextLine();
        System.out.print("Введите рост третьего человека: ");
        final int height3 = readInt(scanner);

        final Human human1 = new Human(name1, height1);
        final Human human2 = new Human(name2, height2);
        final Human human3 = new Human(name3, height3);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }

    // задание 2
    private static void executeTask2(final Scanner scanner) {
        System.out.print("Введите имя (одно слово): ");
        final String name1 = scanner.nextLine();

        System.out.print("Введите имя и фамилию: ");
        final String[] parts2 = scanner.nextLine().split(" ", 2);
        final String name2 = parts2[0];
        final String surname2 = parts2.length > 1 ? parts2[1] : null;

        System.out.print("Введите имя, фамилию и отчество: ");
        final String[] parts3 = scanner.nextLine().split(" ", 3);
        final String name3 = parts3[0];
        final String surname3 = parts3.length > 1 ? parts3[1] : null;
        final String otchestvo3 = parts3.length > 2 ? parts3[2] : null;

        final Name n1 = new Name(name1);
        final Name n2 = new Name(name2, surname2);
        final Name n3 = new Name(name3, surname3, otchestvo3);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }

    // задание 3
    private static void executeTask3(final Scanner scanner) {
        System.out.print("Введите название отдела: ");
        final String deptName = scanner.nextLine();
        final Department it = new Department(deptName);

        final Employee petrov = createEmployee(
                scanner, it, "Petrov");
        final Employee kozlov = createEmployee(
                scanner, it, "Kozlov");
        final Employee sidorov = createEmployee(
                scanner, it, "Sidorov");

        it.setCeo(kozlov);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
    }

    // задание 4
    private static void executeTask4(final Scanner scanner) {
        System.out.print("Введите название отдела: ");
        final String deptName = scanner.nextLine();
        final Department it = new Department(deptName);

        final Employee petrov = createEmployee(
                scanner, it, "Petrov");
        final Employee kozlov = createEmployee(
                scanner, it, "Kozlov");
        final Employee sidorov = createEmployee(
                scanner, it, "Sidorov");

        it.setCeo(kozlov);

        final List<Employee> employees =
                kozlov.getDepartment().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }

    // задание 5
    private static void executeTask5(final Scanner scanner) {
        System.out.print(
                "Введите начальное количество патронов "
                        + "(или " + DEFAULT_CHOICE
                        + " для значения по умолчанию): ");
        final int rounds = readInt(scanner);
        System.out.print(
                "Сколько раз выстрелить? ");
        final int shots = readInt(scanner);

        final Pistol pistol;
        if (rounds == DEFAULT_CHOICE) {
            pistol = new Pistol();
        } else {
            pistol = new Pistol(rounds);
        }

        for (int i = 1; i <= shots; i++) {
            pistol.shoot();
        }
    }

    /**
     * Вспомогательная функция для чтения чисел
     * @param scanner сканер
     * @return число (input)
     */
    private static int readInt(final Scanner scanner) {
        while (true) {
            try {
                final int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.print(
                        "Ошибка ввода. Введите целое число: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Создание сотрудника с запросом имени
     * @param scanner сканер
     * @param department раздел
     * @param defaultName fall-back имя
     * @return новый инстанс employee
     */
    private static Employee createEmployee(
            final Scanner scanner,
            final Department department,
            final String defaultName) {
        System.out.print(
                "Введите имя сотрудника (или Enter для \""
                        + defaultName + "\"): ");
        final String line = scanner.nextLine();
        final String name = line.isEmpty()
                ? defaultName
                : line;
        return new Employee(name, department);
    }
}
