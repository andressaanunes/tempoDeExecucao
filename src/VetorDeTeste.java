import java.util.Random;

public class VetorDeTeste {
    private int[] vetor;
    private Random random;

    public VetorDeTeste(int tamanho) {
        vetor = new int[tamanho];
        random = new Random();
        gerarValoresAleatorios();
    }

    private void gerarValoresAleatorios() {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt();
        }
    }

    public int[] getVetor() {
        return vetor;
    }
}
