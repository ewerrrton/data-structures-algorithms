public class KthFinder {

    public int kesimo(int[] v, int k) {

        ArrayList<Integer> valores = new ArrayList<Integer>();

        // Cria uma heap máxima a partir do array
        Heap heap = new Heap(v);

        int maior = 0;

        // Remove o maior valor da heap k vezes
        for (int i = 0; i < k; i++) {
            maior = heap.remove();
            valores.add(maior);
        }

        return maior;  // Retorna o k-ésimo maior elemento
    }
}

