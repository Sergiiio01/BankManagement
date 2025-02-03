class BankAccount {
    public double getBalance() {
        return balance;
    }

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(double amount, String threadName) {
        System.out.println(threadName + " is trying to withdraw " + amount);

        while (balance < amount) {
            try {
                System.out.println("Insufficient balance. Waiting for deposit...");
                wait(); // Wait until there is enough balance
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Current balance: " + balance);
    }

    public synchronized void deposit(double amount, String threadName){
        System.out.println(threadName + " is trying to deposit " + amount);

        System.out.println(threadName + " successfully deposited " + amount);
        balance += amount;
        System.out.println("Remaining balance: " + balance);

    }
}