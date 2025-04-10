public class Circular {

    private int[] fila;
    private int head;
    private int tail;
    private int size;


    public Circular(int capacidade) {
        this.fila = new fila[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }


    public boolean isEmpty() {
        return this.head == -1;

    }

    public boolean isFull() {
        return (this.tail + 1) % this.fila.length == this.head;
    }

    public void addLast(int element) {
        // adotada a abordagem de nao sobrescrever o mais antigo
        if(isFull()) {
            throw new RuntimeException("Fila cheia");
        }
        else {
            this.size++;

            if(isEmpty()) {
                this.head = 0;
            }

            this.tail = (tail + 1) % this.fila.length;
            this.fila[tail] = element;
        }
    }

    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("fila vazia");
        }

        this.size--;
        int removido = this.fila[this.head];

        if(this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % fila.length;
        }

        return removido;.
    }

    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("fila vazia");
        }

        return this.fila[this.head];
    }
    
    public int getLast() {
        if(isEmpty()) {
            throw new RuntimeException("fila vazia");
        }

        return this.fila[this.tail];
    }



    public String toString() {
        if(isEmpty()) {
            return "";
        }

        int i = this.head;
        StringBuilder sb = new StringBuilder();

        sb.append(this.fila[i]);
        while(i != this.tail) {
            i = (i + 1) % this.fila.length;

            sb.append(", ").append(this.fila[i]);

        }

        return sb.toString();
    }
// Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro.
    public int indexOf(int valor){
        if(isEmpty()) {
            return -1;
        }
 
        int index = this.head;
        return indexOf(valor, index);
    }

    private int indexOf(int valor, int index) {
        if(this.fila[index] == valor) {
            return index;
        }

        if(index == this.tail) {
            return -1;
        }

        return indexOf(valor, (index+ 1) % this.fila.length);
    }

    public int lastIndexOf(int valor) {
        if(isEmpty()) {
            return -1;
        }

        int index = this.head;
        int ultimaOcor = -1;

        return lastIndexOf(valor, index, ultimaOcor);
    }



    private int lastIndexOf(int valor, int index, int ultimaOcor) {
        if(this.fila[index] == valor) {
            ultimaOcor = index;
        }

        if(index == this.tail) {
            return ultimaOcor;
        }

        return lastIndexOf(valor, (index + 1) % fila.length, ultimaOcor);
    }

    public int size() {
        if(isEmpty() {
            return -1;
        }

        return this.size;
    }



}
