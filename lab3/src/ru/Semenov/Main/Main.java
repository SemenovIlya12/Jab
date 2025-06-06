package ru.Semenov.Main;

import ru.Semenov.Geometry.*;
import ru.Semenov.Persons.*;
import ru.Semenov.Weapon.*;
import java.util.Scanner;

public class Main {

    public static double power(String x, String y ){
        return Math.pow(Integer.parseInt(x), Integer.parseInt(y));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write number of a task: ");
        try {
            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    Pistol p = new Pistol(0, 7);
                    p.reload(3);
                    p.shoot(5);
                    p.reload(8);
                    p.shoot(2);
                    p.discharge();
                    p.shoot();
                } break;
                case 2: {
                    Name normal = new Name("Vladimir");
                    Name normal2 = new Name("Vladimir", "Mayakovski");
                    Name normal3 = new Name("Segey", "Sergeyevich", "Sergeev");

                    System.out.println(normal);
                    System.out.println(normal2);
                    System.out.println(normal3);

                    Thread.sleep(3000);
                    //Name Abnormal = new Name(" ");
                    Name Abnormal2 = new Name(null);  // Выкидывает ошибку.
                } break;
                case 3: {
                    PhoneVocab vb = new PhoneVocab();
                    System.out.println(vb);

                    vb.add("11-11", "Ivan");
                    vb.add("12-12", "Ian");
                    System.out.println(vb.GetNumber("Ben"));
                    System.out.println(vb.GetNumber("Ben2"));

                    System.out.println(vb.isInVocab("11-11"));
                    vb.remove("Volodimir");

                    System.out.println(vb.getSize());

                    System.out.println(vb);
                    System.out.println("");

                    System.out.println(vb.getNamesBySubstring("I"));
                    System.out.println("");
                    System.out.println(vb.getAllNames());
                    System.out.println("");
                    System.out.println(vb.getAllNumbers());
                    System.out.println("");
                    System.out.println(vb.getAllPairs());


                } break;
                case 4: {
                    //Gun g = new Gun();   // 30/30
                    //Gun g = new Gun(4);
                    Gun g = new Gun(4, 2);
                    //g.Reload(5);
                    System.out.println(g.getRounds());
                    //g.Shoot(2);
                    g.shoot(3);
                } break;
                case 5: {
                    Shooter s1 = new Shooter("Mike");


                    Shooter s2 = new Shooter("2");
                    Pistol g2 = new Pistol(3,5);
                    s2.setWeapon(g2);

                    Shooter s3 = new Shooter("3");
                    Gun g3 = new Gun(10,2);
                    s3.setWeapon(g3);

                    s1.shoot();
                    s2.shoot();
                    s3.shoot();

                } break;
                case 6: {
                    Point p1 = new Point(2,4);
                    Point p2 = new Point(2, 4);
                    Point p3 = new Point(2, 8);

                    System.out.println("Does point "+ p1 + " equals to " + p2 + "?: " + p1.equals(p2));
                    System.out.println("Does point "+ p1 + " equals to " + p3 + "?: " + p1.equals(p3));
                } break;
                case 7 : {
                    if (args.length < 2) throw new IllegalArgumentException();

                    System.out.println(power(args[0], args[1]));

                } break;

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

