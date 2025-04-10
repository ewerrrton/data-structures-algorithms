public class InserctionSort {

    public InserctionSort(int[] v) {
        for(int i = 1; i < v.length; i++) {
            
            int j = i;
            
            while(j > 0 && v[j] < v[j-1]) {

                int aux = v[j];
                v[j] = v[j-1];
                v[j-1] = aux;

                j--;
            }
       
        }
    }


    public static void main(String[] args) {
        int[] valores = {64, 25, 12, 22, 11};
        System.out.println("Array original:");
        printArray(valores);


        InserctionSort sort = new InserctionSort(valores);

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
