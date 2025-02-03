
class DepositThread extends Thread {
    private BankAccount account;
    private double amount;
    private String threadName;
    private int waitTime;

    public DepositThread(BankAccount account, double amount, String threadName, int waitTime) {
        this.account = account;
        this.amount = amount;
        this.threadName = threadName;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        while (true) {

                try {
                    account.deposit(amount, threadName);
                    sleep(this.waitTime);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

    }
}