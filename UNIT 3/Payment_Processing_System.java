import java.util.*;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double a) {}
}

class UPIPayment implements Payment {
    public void pay(double a) {}
}

class NetBankingPayment implements Payment {
    public void pay(double a) {}
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment p, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    double processPayment(Payment p, double a) {
        if (p instanceof CreditCardPayment) return a * 1.02;
        if (p instanceof UPIPayment) return a * 1.01;
        return a * 1.015;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PaymentProcessor processor = new OnlinePaymentProcessor();

        while (n-- > 0) {
            int type = s.nextInt();
            double amount = s.nextDouble();
            Payment p;

            if (type == 1) p = new CreditCardPayment();
            else if (type == 2) p = new UPIPayment();
            else p = new NetBankingPayment();

            double result = processor.processPayment(p, amount);

            String name = type == 1 ? "CreditCard" :
                          type == 2 ? "UPI" : "NetBanking";

            System.out.printf("%s %.2f%n", name, result);
        }
    }
