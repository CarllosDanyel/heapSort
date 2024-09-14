
import java.util.Arrays;

public class ArvoreBI {

    public static void main(String[] args) {
        int[] array = new int[500000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }

        long tempoInicio = System.currentTimeMillis();
        heapSort(array);
        long tempoFim = System.currentTimeMillis();

        long tempoExecucao = tempoFim - tempoInicio;
        String tempoFormatado = String.format("%02d:%02d:%02d", tempoExecucao / 3600000, (tempoExecucao % 3600000) / 60000, (tempoExecucao % 60000) / 1000);

        System.out.println("Array ordenado: " + Arrays.toString(array));
        System.out.println("Tempo de execução: " + tempoFormatado);
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && array[esquerda] > array[maior]) {
            maior = esquerda;
        }

        if (direita < n && array[direita] > array[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int troca = array[i];
            array[i] = array[maior];
            array[maior] = troca;

            heapify(array, n, maior);
        }
    }
}
