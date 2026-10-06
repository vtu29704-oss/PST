import java.util.*;

class Vehicle {
    String number;
    double rent;
    Vehicle(String n, double r) {
        number = n;
        rent = r;
    }
    double calculateRent(int d) {
        return rent * d;
    }
}

class Car extends Vehicle {
    Car(String n, double r) { super(n, r); }
}

class Bike extends Vehicle {
    Bike(String n, double r) { super(n, r); }
    double calculateRent(int d) { return rent * d * 0.9; }
}

class Truck extends Vehicle {
    Truck(String n, double r) { super(n, r); }
    double calculateRent(int d) { return rent * d * 1.2; }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        while (n-- > 0) {
            int type = s.nextInt();
            String num = s.next();
            double rent = s.nextDouble();
            int days = s.nextInt();

            Vehicle v;
            if (type == 1) v = new Car(num, rent);
            else if (type == 2) v = new Bike(num, rent);
            else v = new Truck(num, rent);

            System.out.printf("%s %.2f%n", num, v.calculateRent(days));
        }
    }
}