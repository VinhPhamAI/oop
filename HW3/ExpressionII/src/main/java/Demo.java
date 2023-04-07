public class Demo {
    public static void main (String[] args)
    {
        BankAccount[] accounts = new BankAccount[]{
                new BankAccount("Vinh", 12345, 100.0, 3),
                new BankAccount("Hoa", 3988 , 20.5, 1),
                new BankAccount("Duong",29422, 12.0, 2)
        };
        InsertionSort.sort(accounts, new BalanceAscending());
        System.out.println("Sorted by balance ascending:");
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
        InsertionSort.sort(accounts, new BalanceDescending());
        System.out.println("Sorted by balance descending:");
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
        InsertionSort.sort(accounts, new TransactionCountDescending());
        System.out.println("Sorted by TransactionCountDescending:");
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}
