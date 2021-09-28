package example;

/**
 * @author Zyi
 */
public class QuickSorter implements Sorter{
    
    int[] arr;
    private StringBuilder plan = new StringBuilder();

    @Override
    public void load(int[] elements) {
        this.arr = elements;
    }

    @Override
    public void sort() {
        quickSort(this.arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, middle + 1, high);
            quickSort(arr, low, middle - 1);
        }
    }

    private int getMiddle(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int temp = arr[low];

        while (i < j) {
            while (temp <= arr[i] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, i);

        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        plan.append(arr[i]).append("<->").append(arr[j]).append("\n");
    }

    @Override
    public String getPlan() {
        return this.plan.toString();
    }
}
