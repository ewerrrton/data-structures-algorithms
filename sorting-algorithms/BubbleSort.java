public class BubbleSort {

public BubbleSort(int[] v) {
        
        for(int i = 0; i < v.length; i++) {
            boolean trocou = false;

            for(int j = 0; j < v.length-i-1; j++) {
                if(v[j] > v[j+1]) {
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                    trocou = true;
                }
            
            }

            if(!trocou) {
                return;
            }
        }
    }


     public static void main(String[] args) {
        int[] valores = {64, 25, 12, 22, 11};
        System.out.println("Array original:");
        printArray(valores);


        BubbleSort sort = new BubbleSort(valores);

        System.out.println("Array ordenado:");
        printArray(valores);
    }


    private static void printArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }


}
