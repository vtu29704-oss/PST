import java.util.*;

abstract class Vehicle {
    abstract int fare(int d);
}

class Bike extends Vehicle {
    int fare(int d) { return d * 5; }
}

class Auto extends Vehicle {
    int fare(int d) { return d * 12; }
}

class Cab extends Vehicle {
    int fare(int d) { return d * 12; }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        while (n-- > 0) {
            String type = s.next();
            int d = s.nextInt();
            Vehicle v;

            if (type.equals("Bike"))
                v = new Bike();
            else if (type.equals("Auto"))
                v = new Auto();
            else if (type.equals("Cab"))
                v = new Cab();
            else {
                System.out.println("Invalid Booking");
                continue;
            }

            if (d <= 0)
                System.out.println("Invalid Booking");
            else
                System.out.println(v.fare(d));
        }
    }
}