import java.util.ArrayList;

public class QuickSort extends SortAlgo{

    @Override
    public void sort(NumList numList) {
        ArrayList<Double> list = numList.getNumList();
        quickSort(list, 0, list.size() - 1);
    }
    private void quickSort(ArrayList<Double> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }
    private int partition(ArrayList<Double> list, int low, int high)
    {
        double pivot = list.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        double temp = list.get(i);
        list.set(i, list.get(high));
        list.set(high, temp);
        return i;
    }
}
