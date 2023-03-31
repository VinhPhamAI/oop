import java.util.Random;

public class Gambler extends Account {
    private Random random;
    private static final double FEE_Mul = 2.0;
    private static final double FEE_Probability = 0.51;
    public Gambler (double initialBalance)
    {
        super(initialBalance,0);
        random = new Random();
    }
    public boolean withdraw(double amount)
    {
        boolean check = super.withdraw(amount);
        if(check)
        {
            if(random.nextDouble() > FEE_Probability)
            {
                setBalance(getBalance() - (amount * FEE_Mul) );
            }
        }
        return check;
    }
    @Override
    public void endMonthCharge()
    {

    }
}
