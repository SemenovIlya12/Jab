package ru.semenov;

import ru.semenov.geometry.Point;
import ru.semenov.persons.Name;
import ru.semenov.persons.PhoneVocab;
import ru.semenov.persons.Shooter;
import ru.semenov.weapon.Gun;
import ru.semenov.weapon.Pistol;
import ru.semenov.weapon.Weapon;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * класс - entrypoint
 */
public class Main {

    /**
     * Точка входа.
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания (1-7): ");
        try {
            final int taskId = scanner.nextInt();
            scanner.nextLine();
            switch (taskId) {
                case 1:
                    runTask1(scanner);
                    break;
                case 2:
                    runTask2(scanner);
                    break;
                case 3:
                    runTask3(scanner);
                    break;
                case 4:
                    runTask4(scanner);
                    break;
                case 5:
                    runTask5(scanner);
                    break;
                case 6:
                    runTask6(scanner);
                    break;
                case 7:
                    runTask7(args);
                    break;
                default:
                    System.out.println("Задания с таким" +
                            " номером нет.");
            }
        } catch (InputMismatchException e) {
            System.out.println(
                    "Ошибка: введите целое число.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // Задание 1
    private static void runTask1(final Scanner scanner) {
        System.out.print("Введите начальное " +
                "количество патронов: ");
        final int initialRounds = readInt(scanner);
        System.out.print("Введите максимальную ёмкость: ");
        final int maxCapacity = readInt(scanner);
        final Pistol pistol = new Pistol(
                initialRounds,
                maxCapacity);

        System.out.print("Сколько патронов зарядить сначала? ");
        final int firstReload = readInt(scanner);
        System.out.println("Возвращено излишков: "
                + pistol.reload(firstReload));

        System.out.print("Сколько выстрелов произвести? ");
        final int firstShots = readInt(scanner);
        pistol.shoot(firstShots);

        System.out.print("Сколько патронов зарядить потом? ");
        final int secondReload = readInt(scanner);
        pistol.reload(secondReload);

        System.out.print("Сколько выстрелов ещё? ");
        final int secondShots = readInt(scanner);
        pistol.shoot(secondShots);

        System.out.println("Разряжаем: " + pistol.discharge());
        pistol.shoot(); // попытка выстрела после разрядки
    }

    // Задание 2
    private static void runTask2(final Scanner scanner) {
        System.out.print("Введите имя (одно слово): ");
        final String singleName = scanner.nextLine();
        final Name name1 = new Name(singleName);

        System.out.print("Введите имя и фамилию " +
                "через пробел: ");
        final String[] parts2 = scanner.nextLine()
                .split(" ", 2);
        final Name name2 = parts2.length == 2
                ? new Name(parts2[0], parts2[1])
                : new Name(parts2[0]);

        System.out.print(
                "Введите имя, фамилию " +
                        "и отчество через пробел: ");
        final String[] parts3 = scanner.nextLine()
                .split(" ", 3);
        final Name name3;
        if (parts3.length == 3) {
            name3 = new Name(parts3[0], parts3[1], parts3[2]);
        } else if (parts3.length == 2) {
            name3 = new Name(parts3[0], parts3[1]);
        } else {
            name3 = new Name(parts3[0]);
        }

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

        // демонстрация ошибки
        System.out.println(
                "Попытка создать имя с null" +
                        " (вызовет исключение):");
        try {
            new Name(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: "
                    + e.getMessage());
        }
    }

    // Задание 3
    private static void runTask3(final Scanner scanner) {
        final PhoneVocab vocab = new PhoneVocab();
        // заполнение через ввод
        System.out.println(
                "Введите пары 'номер,имя':");
        while (true) {
            System.out.print("Номер и имя через запятую: ");
            final String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            final String[] parts = line.split(",", 2);
            if (parts.length == 2) {
                final String phone = parts[0].trim();
                final String name = parts[1].trim();
                vocab.add(phone, name);
            }
        }
        System.out.println(vocab);
        System.out.print("Введите имя для поиска номера: ");
        final String searchName = scanner.nextLine();
        System.out.println(vocab.getNumber(searchName));
        System.out.print(
                "Введите подстроку для поиска имён: ");
        final String sub = scanner.nextLine();
        final List<String> namesBySub =
                vocab.getNamesBySubstring(sub);
        System.out.println("Найденные имена: " + namesBySub);
        System.out.println("Все номера: "
                + vocab.getAllNumbers());
        System.out.println("Все пары: " + vocab.getAllPairs());
    }

    // Задание 4
    private static void runTask4(final Scanner scanner) {
        System.out.print(
                "Введите максимальную ёмкость магазина: ");
        final int max = readInt(scanner);
        System.out.print("Введите скорострельность: ");
        final int speed = readInt(scanner);
        final Gun gun = new Gun(max, speed);
        System.out.println("Текущие патроны: "
                + gun.getRounds());
        System.out.print("Сколько выстрелов (очередей)? ");
        final int bursts = readInt(scanner);
        gun.shoot(bursts);
    }

    // Задание 5
    private static void runTask5(final Scanner scanner) {
        final Shooter shooter1 = new Shooter("Mike");
        // у стрелка 1 нет оружия

        System.out.print(
                "Введите имя второго стрелка: ");
        final String name2 = scanner.nextLine();
        final Shooter shooter2 = new Shooter(name2);
        System.out.print(
                "Введите начальные патроны для пистолета: ");
        final int rounds2 = readInt(scanner);
        System.out.print(
                "Введите максимальную ёмкость пистолета: ");
        final int max2 = readInt(scanner);
        final Pistol pistol2 = new Pistol(rounds2, max2);
        shooter2.setWeapon(pistol2);

        System.out.print(
                "Введите имя третьего стрелка: ");
        final String name3 = scanner.nextLine();
        final Shooter shooter3 = new Shooter(name3);
        System.out.print(
                "Введите макс. ёмкость пулемёта: ");
        final int max3 = readInt(scanner);
        System.out.print(
                "Введите скорострельность пулемёта: ");
        final int speed3 = readInt(scanner);
        final Gun gun3 = new Gun(max3, speed3);
        shooter3.setWeapon(gun3);

        System.out.println("Стрельба:");
        shooter1.shoot();
        shooter2.shoot();
        shooter3.shoot();
    }

    // Задание 6
    private static void runTask6(final Scanner scanner) {
        System.out.print("Введите x1: ");
        final int x1 = readInt(scanner);
        System.out.print("Введите y1: ");
        final int y1 = readInt(scanner);
        System.out.print("Введите x2: ");
        final int x2 = readInt(scanner);
        System.out.print("Введите y2: ");
        final int y2 = readInt(scanner);
        final Point p1 = new Point(x1, y1);
        final Point p2 = new Point(x2, y2);
        System.out.println("Точка " + p1 + " равна " + p2
                + "? " + p1.equals(p2));
    }

    // Задание 7
    private static void runTask7(final String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Необходимо два аргумента: " +
                            "число и степень.");
        }
        final double base = Double.parseDouble(args[0]);
        final double exponent = Double.parseDouble(args[1]);
        System.out.println(base + "^" + exponent + " = "
                + Math.pow(base, exponent));
    }

    private static int readInt(final Scanner scanner) {
        while (true) {
            try {
                final int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.print(
                        "Ошибка. Введите целое число: ");
                scanner.nextLine();
            }
        }
    }
}