import java.util.Date;

public class BubbleSort {

    private int[] array;
    private int array_id;
    private Date startTime;
    private Date endTime;
    private int arraySize;
    private int numComparisons;
    private int numSwaps;

    public BubbleSort(int[] array, int array_id) {
        this.array = array;
        this.arraySize = array.length;
        this.numComparisons = 0;
        this.numSwaps = 0;
        this.array_id = array_id;
    }

    public void sort() {
        startTime = new Date();
        bubbleSort();
        endTime = new Date();
    }

    private void bubbleSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                numComparisons++;
                if (array[j] > array[j + 1]) {
                    // Trocar os elementos array[j] e array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    numSwaps++;
                }
            }
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
        aux.append("BubbleSort");
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