package CoffeeWallet.com;

class CoffeeWallet {
    String name;
    double balance;

    CoffeeWallet(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void addFunds(double amount) {
        balance += amount;
        System.out.println("Added: Rs." + amount);
        System.out.println("Balance: Rs." + balance);
    }

    void purchase(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Purchase successful: Rs." + amount);
            System.out.println("Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        CoffeeWallet w = new CoffeeWallet("Rutuja", 1000);

        w.display();
        w.addFunds(300);
        w.purchase(150);
        w.purchase(800);
    }
}
