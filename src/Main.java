import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Tamanhos dos vetores de teste
        int[] tamanhos = {62500, 125000, 250000, 375000};

        // Para cada tamanho de vetor
        for (int tamanho : tamanhos) {
            testarVetor(tamanho);
        }

        // Teste com vetor de tamanho 10000 para o QuickSort
        testarQuickSort(10000);
    }

    public static void testarVetor(int tamanho) {
        QuickSort quickSort = new QuickSort();
        BubbleSort bubbleSort = new BubbleSort();
        long tempoTotalQuickSort = 0;
        long tempoTotalBubbleSort = 0;

        // Realizar 50 testesS
        for (int i = 0; i < 50; i++) {
            // Cria uma nova instância da classe VetorDeTeste com o tamanho atual
            VetorDeTeste vetorDeTeste = new VetorDeTeste(tamanho);
            int[] vetor1 = vetorDeTeste.getVetor();
            int[] vetor2 = Arrays.copyOf(vetor1, vetor1.length);

            // Mede o tempo de execução do algoritmo QuickSort
            long inicioQuickSort = System.currentTimeMillis();
            quickSort.ordenar(vetor1, 0, vetor1.length - 1);
            long fimQuickSort = System.currentTimeMillis();

            // Mede o tempo de execução do algoritmo BubbleSort
            long inicioBubbleSort = System.currentTimeMillis();
            bubbleSort.ordenar(vetor2);
            long fimBubbleSort = System.currentTimeMillis();

            // Calcula o tempo de execução e adiciona ao tempo total
            tempoTotalQuickSort += fimQuickSort - inicioQuickSort;
            tempoTotalBubbleSort += fimBubbleSort - inicioBubbleSort;
        }

        // Calcula a média do tempo de execução
        long mediaQuickSort = tempoTotalQuickSort / 50;
        long mediaBubbleSort = tempoTotalBubbleSort / 50;

        System.out.println("A média do tempo de execução para um vetor de tamanho " + tamanho + " foi: ");
        System.out.println("QuickSort: " + mediaQuickSort + " milissegundos");
        System.out.println("BubbleSort: " + mediaBubbleSort + " milissegundos");
    }

    public static void testarQuickSort(int tamanho) {
        QuickSort quickSort = new QuickSort();

        // Realizar 10 testes com vetores aleatórios e ordenados
        for (int i = 0; i < 10; i++) {
            VetorDeTeste vetorDeTesteAleatorio = new VetorDeTeste(tamanho);
            int[] vetorAleatorio = vetorDeTesteAleatorio.getVetor();

            int[] vetorOrdenado = IntStream.rangeClosed(1, tamanho).toArray();

            long inicioAleatorio = System.currentTimeMillis();
            quickSort.ordenar(vetorAleatorio, 0, vetorAleatorio.length - 1);
            long fimAleatorio = System.currentTimeMillis();

            long inicioOrdenado = System.currentTimeMillis();
            quickSort.ordenar(vetorOrdenado, 0, vetorOrdenado.length - 1);
            long fimOrdenado = System.currentTimeMillis();

            System.out.println("Tempo de execução QuickSort para um vetor aleatório de tamanho " + tamanho + ": " + (fimAleatorio - inicioAleatorio) + " milissegundos");
            System.out.println("Tempo de execução QuickSort para um vetor ordenado de tamanho " + tamanho + ": " + (fimOrdenado - inicioOrdenado) + " milissegundos");
        }
    }
}
