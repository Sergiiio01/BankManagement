


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread thread1 = new DepositThread(account, 300, "Thread 1", 1000);
        Thread thread2 = new WithdrawalThread(account, 200, "Thread 2", 2000);
        Thread thread3 = new WithdrawalThread(account, 5000, "Thread 3", 3000);
        Thread interest = new InterestThread(account, 5000, 2);

        thread1.start();
        thread2.start();
        thread3.start();
        interest.start();


    }
}
