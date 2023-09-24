public class MyArray {
    private int id;
    private int vet[];

    public MyArray(int tam, int id) {
        this.id = id;
        this.vet = new int[tam];
        fillVetor();
    }

    private void fillVetor() {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = Utilss.gerarNumeroAleatorio();
        }
    }

    public int getId() {
        return id;
    }

    public int[] cloneVetor() {
        int[] clone = new int[vet.length];
        System.arraycopy(vet, 0, clone, 0, vet.length);
        return clone;
    }
}
