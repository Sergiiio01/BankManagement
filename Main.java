


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new WithdrawalThread(account, 700, "Thread 1");
        Thread t2 = new WithdrawalThread(account, 500, "Thread 2");


    }
}
