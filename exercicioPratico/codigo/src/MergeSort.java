import java.util.Date;

public class MergeSort {

    private int[] array;
    private int array_id;
    private Date startTime;
    private Date endTime;
    private int arraySize;
    private int numComparisons;
    private int numSwaps;

    public MergeSort(int[] array, int array_id) {
        this.array = array;
        this.arraySize = array.length;
        this.numComparisons = 0;
        this.numSwaps = 0;
        this.array_id = array_id;
    }

    public void sort() {
        startTime = new Date();
        mergeSort(0, array.length - 1);
        endTime = new Date();
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            numComparisons++;
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
                numSwaps++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getArraySize() {
        return arraySize;
    }

    public double getExecutionTimeInSeconds() {
        long diffInMillis = endTime.getTime() - startTime.getTime();
        return diffInMillis / 1000.0;
    }

    public double getExecutionTimeInMillis() {
        long diffInMillis = endTime.getTime() - startTime.getTime();
        return diffInMillis;
    }

    public int getNumComparisons() {
        return numComparisons;
    }

    public int getNumSwaps() {
        return numSwaps;
    }

    public String toCSV() {
        StringBuilder aux = new StringBuilder();
        aux.append(this.arraySize);
        aux.append(";");
        aux.append(this.array_id);
        aux.append(";");
        aux.append("MergeSort");
        aux.append(";");
        aux.append(this.startTime);
        aux.append(";");
        aux.append(this.numComparisons);
        aux.append(";");
        aux.append(this.numSwaps);
        aux.append(";");
        aux.append(this.endTime);
        aux.append(";");
        aux.append(this.getExecutionTimeInMillis());
        // aux.append(System.lineSeparator());
        return aux.toString();
    }
}