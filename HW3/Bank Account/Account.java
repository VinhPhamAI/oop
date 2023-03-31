abstract public class Account {
    private double balance;
    private int transactions;
    public Account (double initialBalance, int transactions)
    {
        balance = initialBalance;
        transactions = 0;
    }
    public double getTransactions(){
        return transactions;
    }
    public void setTransactions(int Transactions)
    {
        this.transactions = Transactions;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double Balance)
    {
        this.balance = Balance;
    }
    public void endMonth(){
        System.out.println("Number of transactions this month: " + transactions);
        System.out.println("Final balance: " + balance);
        transactions = 0;
    }
    public void deposit (double amount)
    {
        balance += amount;
        transactions++;
    }
    public abstract void endMonthCharge();
    public boolean withdraw (double amount)
    {
        if(balance >= amount){
            balance -= amount;
            transactions++;
            return true;
        }
        return false;
    }

}
