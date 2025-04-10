import java.util.Arrays;
public class CoutingSort {

    public static int[] coutingSort(int[] a, int k) {
        
        int[] c = new int[k];

        for(int i = 0; i < a.length; i++) {
            c[a[i]-1] +=1;
        }

        for(int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[a.length];

        for(int i = a.length-1; i >= 0; i--) {
            b[c[a[i]-1]-1] = a[i];
            c[a[i]-1] -=1;
        }

        return b;
    }


    public static int[] coutingSortGeral(int[] a, int maior, int menor) {

        int[] c = new int[maior - menor + 1];

        for(int i = 0; i < a.length; i++) {
            c[a[i]- menor] +=1;
        }

        for(int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[a.length];

        for(int i = a.length-1; i >= 0; i--) {
            b[c[a[i] - menor]-1] = a[i];
            c[a[i]-menor] -=1;
        }

        return b;
    }


    public static void main(String[] args) {

        CoutingSort couting = new CoutingSort();

        int[] v = new int[]{18, 1, 2, 56, 9, 23, 2, 5, -6, 0, 1};
        int[] resultado = couting.coutingSortGeral(v, 56, -6);

        System.out.println(Arrays.toString(resultado));
    }


}
