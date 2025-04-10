import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> saida = new ArrayList<Integer>();
      
        int[] valores = new int[]{13, 9, 5, 2, 87, 4};
        Heap heap = new Heap(valores); 
        
        for (int i = valores.length; i > 0; i--) {
            int maior = heap.remove();
            saida.add(maior);
            System.out.println(maior);
        }

        Scanner sc = new Scanner(System.in);

        int kesimo = sc.nextInt();

        System.out.println(saida.get(kesimo-1));
    }
}

