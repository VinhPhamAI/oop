import java.util.ArrayList;

public class BubbleSort extends SortAlgo{

    @Override
    public void sort(NumList numList) {
        ArrayList<Double> list = numList.getNumList();
        int n = list.size();
        double temp = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
