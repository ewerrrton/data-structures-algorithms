import java.util.Arrays;

public class MergeSort {
    
    public void mergeSort(int[]v, int ini, int fim) {
        if(ini < fim) {
            int meio = (ini + fim) / 2;

            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, meio, fim);
        }
    }

    public void merge(int[]v, int ini, int meio, int fim) {
        int[] helper = new int[v.length];
        
        for(int i = 0; i < v.length; i++) {
            helper[i] = v[i];
        }

        int i = ini;
        int j = meio+1;
        int k = ini;


        while(i <= meio && j <= fim) {
            if(helper[i] < helper[j]) {
                v[k++] = helper[i++];
            
            } else {
                v[k++] = helper[j++];
            }
        }

        while(i <= meio) {
            v[k++] = helper[i++];
        }

        while(j <= fim) {
            v[k++] = helper[j++];
        }
    }


    public static void main(String[] args) {

        int[] v = new int[]{13, 67, 33, 2, 3, 56, 89, 453, 24};
        System.out.println("Array antes:");
        System.out.println(Arrays.toString(v));

        MergeSort merge = new MergeSort();

        merge.mergeSort(v, 0, v.length-1);
        
        System.out.println(Arrays.toString(v));


    }
}




