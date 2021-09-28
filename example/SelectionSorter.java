package example;

/**
 * @author Zyi
 */
public class SelectionSorter implements Sorter{
    int[] arr;
    private StringBuilder plan = new StringBuilder();

    @Override
    public void load(int[] elements) {
        this.arr = elements;
    }

    @Override
    public void sort() {
        selectionSort(this.arr, 0, arr.length - 1);
    }

    @Override
    public String getPlan() {
        return this.plan.toString();
    }

    private void selectionSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }

        int minElement = Integer.MAX_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            minElement = Math.min(minElement, arr[i]);
        }

        // 找出最小元素并交换
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == minElement) {
                swap(arr, startIndex, i);
                break;
            }
        }

        // 递归，缩小问题规模
        selectionSort(arr, startIndex + 1, endIndex);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        plan.append(arr[i]).append("<->").append(arr[j]).append("\n");
    }
}
