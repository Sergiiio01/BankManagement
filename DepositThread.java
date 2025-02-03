
class DepositThread extends Thread {
    private BankAccount account;
    private double amount;
    private String threadName;

    public DepositThread(BankAccount account, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        account.deposit(amount, threadName);
    }
}