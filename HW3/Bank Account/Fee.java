class Fee extends Account {

    private static final double FEE = 5.00;

    public Fee(double initialBalance) {
        super(initialBalance, 0);
    }

    @Override
    public void endMonthCharge() {
        setBalance(getBalance() - FEE);
    }
}
