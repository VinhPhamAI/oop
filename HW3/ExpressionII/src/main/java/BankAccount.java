public class BankAccount {
    private String ownerName;
    private int accountNumber;
    private double balance;
    private int transactionCount;

    public BankAccount(String ownerName, int accountNumber, double balance, int transactionCount) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionCount = transactionCount;
    }
    public double getTransactions(){
        return transactionCount;
    }
    public void setTransactions(int Transactions)
    {
        this.transactionCount = Transactions;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double Balance)
    {
        this.balance = Balance;
    }
    public void endMonth(){
        System.out.println("Number of transactions this month: " + transactionCount);
        System.out.println("Final balance: " + balance);
        transactionCount = 0;
    }
    public void deposit (double amount)
    {
        balance += amount;
        transactionCount++;
    }
    public boolean withdraw (double amount)
    {
        if(balance >= amount){
            balance -= amount;
            transactionCount++;
            return true;
        }
        return false;
    }

}
