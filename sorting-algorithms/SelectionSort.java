public class SelectionSort {

    public SelectionSort(int[] valores) {
    
        for(int i = 0; i < valores.length; i++) {

            int indexMenor = i;

            for(int j = i+1; j < valores.length; j++) {
                if(valores[j] < valores[indexMenor]) {
                    indexMenor = j;
                }
            }

              int aux = valores[indexMenor];
              valores[indexMenor] = valores[i];
              valores[i] = aux;
            
        }       

    }


   
    public static void main(String[] args) {
        int[] valores = {64, 25, 12, 22, 11}; 
        System.out.println("Array original:");
        printArray(valores); 

       
        SelectionSort sort = new SelectionSort(valores);

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


