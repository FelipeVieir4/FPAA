import java.util.Date;

public class QuickSort {

    private int[] array;
    private int array_id;
    private Date startTime;
    private Date endTime;
    private int arraySize;
    private int numComparisons;
    private int numSwaps;

    public QuickSort(int[] array, int array_id) {
        this.array = array;
        this.arraySize = array.length;
        this.numComparisons = 0;
        this.numSwaps = 0;
        this.array_id = array_id;
    }

    public void sort() {
        startTime = new Date();
        quickSort(0, array.length - 1);
        endTime = new Date();
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            numComparisons++; // Incrementa o contador de comparações
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        numSwaps++; // Incrementa o contador de trocas

        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
        return diffInMillis / 1000.0; // Convertendo para segundos
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
        // Vet tam;Vet id;Sort type; start; comp; swap; end; duration (seg)
        StringBuilder aux = new StringBuilder();
        aux.append(this.arraySize);
        aux.append(";");
        aux.append(this.array_id);
        aux.append(";");
        aux.append("QuickSort");
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
