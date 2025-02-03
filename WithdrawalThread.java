
class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;
    private String threadName;
    private int waitTime;

    public WithdrawalThread(BankAccount account, double amount, String threadName, int waitTime) {
        this.account = account;
        this.amount = amount;
        this.threadName = threadName;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                while (true) {
                    try {
                        account.withdraw(amount, threadName);
                        this.wait(this.waitTime);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }

}