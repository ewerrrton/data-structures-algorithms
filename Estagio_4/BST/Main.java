import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] entradas = sc.nextLine().split(" ");
        
        for(String i : entradas) {
            bst.add(Integer.parseInt(i));
        }

        //int valor = sc.nextInt();
        //Node value = bst.search(valor);

       //bst.predecessorTST(value);
       //
        int saida = bst.somaFolhas();
        System.out.println(saida);

    }

}
