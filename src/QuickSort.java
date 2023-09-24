public class QuickSort {
    // Método para trocar elementos de lugar no vetor
    static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    // Método para realizar a partição do vetor
    static int particionar(int[] vetor, int baixo, int alto) {
        int pivo = vetor[alto];
        int i = (baixo - 1);

        for (int j = baixo; j <= alto - 1; j++) {
            if (vetor[j] < pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, alto);
        return (i + 1);
    }

    // Método para realizar a ordenação QuickSort
    public void ordenar(int[] vetor, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particionar(vetor, baixo, alto);

            ordenar(vetor, baixo, pi - 1);
            ordenar(vetor, pi + 1, alto);
        }
    }
}
