import java.io.PrintStream;

class BankAccount {

    private int interest;
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.interest=0;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void withdraw(double amount, String threadName) {


        while (balance < amount) {
            try {
                System.out.println("\n\n" + threadName + " is trying to withdraw " + amount);
                System.out.println("No balance enough");
                wait(); // Wait until there is enough balance
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n" + threadName + " is trying to withdraw " + amount);
        balance -= amount;
        System.out.println("Withdrawn: " + (amount * 1 + (this.interest / 100)) + " | Current balance: " + balance);
        notify();
    }

    public synchronized void deposit(double amount, String threadName) {
        System.out.println("\n\n" + threadName + " is trying to deposit " + amount);

        System.out.println(threadName + " successfully deposited " + amount);
        balance += amount;
        System.out.println("Remaining balance: " + balance);
        notify();

    }

    public synchronized void addInterest(double interest){
        System.out.println(interest + "% interest added.");
        System.out.println("Total interest: " + this.interest);
        this.interest+=interest;
        this.balance = this.balance * (1 + (this.interest / 100));
        System.out.println("Balance after interest: " + this.balance);
        notify();
    }
}