class Nickle_n_Dime extends Account{
    private int withdrawalCount;
    private static final double FEE_Withdraw = 0.5;
    public Nickle_n_Dime (double initialBalance)
    {
        super(initialBalance,0);
        withdrawalCount = 0;
    }

    public boolean withdraw (double amount)
    {
        boolean answer = super.withdraw(amount);
        if (answer)
        {
            withdrawalCount++;
        }
        return answer;
    }

    @Override
    public void endMonthCharge()
    {
        setBalance(getBalance() - (withdrawalCount*FEE_Withdraw));
        withdrawalCount = 0;
    }

}
