import java.io.IOException;

public class App {

    public static void main(String[] args) {

        // PARTE 01

        MyArray myArrays[] = new MyArray[250];

        for (int i = 0; i < 50; i++) {
            myArrays[i] = new MyArray(62500, i);
        }
        for (int i = 50; i < 100; i++) {
            myArrays[i] = new MyArray(125000, i);
        }
        for (int i = 100; i < 150; i++) {
            myArrays[i] = new MyArray(250000, i);
        }
        for (int i = 150; i < 200; i++) {
            myArrays[i] = new MyArray(375000, i);
        }
        for (int i = 200; i < 250; i++) {
            myArrays[i] = new MyArray(1000000, i);
        }

        for (MyArray myArray : myArrays) {
            int vetClone1[] = myArray.cloneVetor();
            int vetClone2[] = myArray.cloneVetor();
            QuickSort quickSort = new QuickSort(vetClone1, myArray.getId());
            MergeSort mergeSort = new MergeSort(vetClone2, myArray.getId());
            mergeSort.sort();
            quickSort.sort();

            try {
                Utilss.salvarNoArquivoCSV(mergeSort.toCSV(), "Relatorio.csv");
                Utilss.salvarNoArquivoCSV(quickSort.toCSV(), "Relatorio.csv");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        // PARTE 02

        int arraySorted[] = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arraySorted[i] = i;
        }

        MyArray othesArray[] = new MyArray[10];

        for (int i = 0; i < 10; i++) {
            othesArray[i] = new MyArray(10000, i);
        }

        for (MyArray myArray : othesArray) {
            int otheArrayClone[] = myArray.cloneVetor();

            QuickSort qsSorted = new QuickSort(arraySorted, myArray.getId());
            QuickSort qsOther = new QuickSort(otheArrayClone, myArray.getId());
            qsSorted.sort();
            qsOther.sort();

            try {
                Utilss.salvarNoArquivoCSV(qsSorted.toCSV() + ";sorted", "RelatorioParte2.csv");
                Utilss.salvarNoArquivoCSV(qsOther.toCSV() + ";random", "RelatorioParte2.csv");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Terminou");
    }
}
