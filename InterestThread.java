public class InterestThread extends Thread {
    private BankAccount account;
    private int waitTime;
    private double interest;

    public InterestThread(BankAccount account, int time, double interest) {
        this.account = account;
        this.waitTime = time;
        this.interest = interest;
    }

    @Override
    public void run() {
        while (true) {

            try {
                account.addInterest(this.interest);
                sleep(this.waitTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
