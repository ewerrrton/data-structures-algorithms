import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class Heap {

    private int[] heap;
    private int tail;


    public ArrayList<Integer> printBFS() {
        Deque<Integer> deque = new LinkedList<Integer>();
        ArrayList<Integer> saida = new ArrayList<Integer>();

        if(!isEmpty()) {

            int index = 0;
            deque.addLast(this.heap[index]);
            
            while(!deque.isEmpty() && index < this.heap.length) {

                int elemento = deque.removeFirst();
                saida.add(elemento);

                if(isValidIndex(left(index))) {
                    deque.addLast(this.heap[left(index)]);
                }

                if(isValidIndex(right(index))) {
                    deque.addLast(this.heap[right(index)]);
                }
                index++;
            }
        }

        return saida;
    }


    public void preOrder() {
        preOrder(0);
    }

    private void preOrder(int i) {
        
        if(i > this.tail) {
            return;
        }
        System.out.print(this.heap[i] + " ");

        preOrder(left(i));
        preOrder(right(i));
    }

    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length-1;
        this.buildHeap();
    }

    private void buildHeap() {
        if(this.heap.length > 1) {
            for(int i = parent(tail); i >= 0; i--) {
                this.heapify(i);
            }
        }
    }


    public boolean isEmpty() {
        return this.tail == -1;
    }


    public void add(int element) {
        if(this.tail + 1 == this.heap.length) {
            this.resize();
        }

        this.tail++;
        this.heap[tail] = element;

        int i = this.tail;

        while(i > 0 && this.heap[i] > this.heap[parent(i)]) {
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;

            i = parent(i);
        }
    }

    public int remove() {

        int removido = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail--;

        heapify(0);
        return removido;
    }


    public void heapify(int index) {
        if(isLeaf(index) || !isValidIndex(index)) {
            return;
        }

        int indexMaior = getIndexMax(index, left(index), right(index));

        if(indexMaior != index) {
            swap(index, indexMaior);
            heapify(indexMaior);
        }

    }

    public int getIndexMax(int index, int left, int right) {

        if(this.heap[index] > this.heap[left]) {
            if(isValidIndex(right)) {
                if(this.heap[index] < this.heap[right]) {
                    return right;
                }
            }
            return index;
       
        } else {
            if(isValidIndex(right)) {
                if(this.heap[right] > this.heap[left]) {
                    return right;
                }
            }

            return left;
        }

    }

    public void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    public boolean isLeaf(int index) {
        return index > parent(tail) && index <=  tail;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;   
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (index-1)/2;
    }

    private void resize() {
        int[] newHeap = new int[this.heap.length*2];

        for(int i = 0; i < this.heap.length; i++) {
            newHeap[i] = this.heap[i];
        }

        this.heap = newHeap;
    }



}
