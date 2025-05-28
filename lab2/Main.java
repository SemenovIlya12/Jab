import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter task number: !");


        try {
            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    Human cleo = new Human("Cleopatra", 152);
                    Human pushkin = new Human("Pushkin", 167);
                    Human mayakovski = new Human("Vladimir", 189);

                    System.out.println(cleo);
                    System.out.println(pushkin);
                    System.out.println(mayakovski);

                } break;
                case 2: {
                    Name cleo = new Name("Клеопатра");
                    Name pushkin = new Name("Александр", "Пушкин", "Сергеевич");
                    Name mayakovski = new Name("Владимир", "Маяковский");
                    Name t1 = new Name("T T T");
                    Name t2 = new Name("T T");
                    Name t3 = new Name("T");
                    System.out.println(cleo);
                    System.out.println(pushkin);
                    System.out.println(mayakovski);

                    System.out.println(t1);
                    System.out.println(t2);
                    System.out.println(t3);
                } break;
                /*case 3: {
                    Time t1 = new Time(10);
                    Time t2 = new Time(10000);
                    Time t3 = new Time(100000);
                    System.out.println(t1);
                    System.out.println(t2);
                    System.out.println(t3);
                } break;*/
                case 3: {  // А ТАКЖЕ НОМЕР 3.4
                    //ArrayList<Human>  humans = new ArrayList<Human>();
                    Department IT = new Department("IT depatment");

                    Employee petrov = new Employee("Petrov", IT);
                    Employee kozlov = new Employee("Kozlov", IT);
                    Employee sidorov = new Employee("Sidorov", IT);

                    IT.setCEO(kozlov);

                    System.out.println(petrov);
                    System.out.println(kozlov);
                    System.out.println(sidorov);


                    /*System.out.println("Getting whole department");
                    ArrayList<employee> emps = Kozlov.GetDepartment().GetEmployees();

                    for (int i = 0; i < emps.size(); i++) {
                        System.out.println(emps.get(i));
                    }*/

                } break;
                case 4: {
                    Department IT = new Department("IT depatment");

                    Employee petrov = new Employee("Petrov", IT);
                    Employee kozlov = new Employee("Kozlov", IT);
                    Employee sidorov = new Employee("Sidorov", IT);

                    IT.setCEO(kozlov);

                    ArrayList<Employee> employees = kozlov.getDepartment().getEmployees();

                    for (int i = 0; i < employees.size(); i++) {
                        System.out.println(employees.get(i));
                    }
                } break;
                case 5: {
                    System.out.println("How many rounds ya want in ya shooter?( -1, if you dont care, why even bother uknow) ");
                    int rounds = sc.nextInt();
                    System.out.println("How many times you want to pull the trigger? ");
                    int shots = sc.nextInt();
                    Pistol pistol;
                    if (rounds == -1) {
                        pistol = new Pistol();
                    } else {
                        pistol = new Pistol(rounds);
                    }

                    for (int i = 1; i <= shots; i++) {
                        pistol.shoot();
                    }
                } break;
            }
        } catch (Exception e) {
            System.out.println("Wrong input "+e.toString());
        }
    }
}
