public class AllEqual {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        if (x == y && x == z) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }

    }
}
