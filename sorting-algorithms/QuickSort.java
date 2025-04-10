import java.util.Arrays;
Çq
public class QuickSort {

    public int mediana(int[] v, int left, int right) {
        int meio = (left + right) / 2;

        int[] sorted = new int[]{v[left], v[meio], v[right]};
        Arrays.sort(sorted);

        if(sorted[1] == v[left]) {
            return left;

        }else if(sorted[1] == v[meio]){
                return meio;
        } else {
            return right;
        
        }
    }


    public void quickSort(int[]v, int left, int right) {
        if(left < right) {
            int indexPivot = partition(v, left, right);
            quickSort(v, left, indexPivot-1);
            quickSort(v, indexPivot+1, right);
         
        }
    }


    public int partition(int[]v, int left, int right) {
        int indexPivot = mediana(v, left, right);
        
        // colocando o pivo na ultima posicao
        swap(v, indexPivot, right);

        int pivot = v[right];
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }

        }
        swap(v, i+1, right);
        return i + 1;
    }
     

    private void swap(int[]v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }


    public static void main(String[] args) {
        QuickSort quick = new QuickSort();

        int[] v = new int[]{13, 56, 3, 45, 26, 70, 1};
        System.out.println(Arrays.toString(v));

        quick.quickSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }
}
