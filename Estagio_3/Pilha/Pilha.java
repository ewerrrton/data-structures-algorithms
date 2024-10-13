public class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }


    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    public void push(int element) {
        if(isFull()) {
            throw new RuntimeException("pilha cheia");
        }

        this.pilha[++topo] = element;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("pilha vazia");
        }

        int removido = this.pop[this.topo];
        this.topo--;
        return removido;
    }

    public int peek() { 
        if(isEmpty()) {
            throw new RuntimeException("pilha vazia");
         }

        return this.pilha[this.topo];

    }

    public String toString() {
        if(isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Pilha aux = new Pilha(this.pilha.length);
        
        while(!isEmpty()) {

            int removido = pop();
            aux.push(removido);
            sb.append(removido).append(", ");

        }

        while(!aux.isEmpty()) {
            int removido = aux.pop();
            push(removido);
        }
        
        if(sb.length() > 2) {
            sb.setLength(sb.length()-2);
        }

        return sb.toString();

    }

    public int indexOf(int valor) {
        if(isEmpty()) {
            return -1;
        }
        
        int posRelativa = 0;

        Pilha temp = new Pilha(this.pilha.length);
        while(!isEmpty()) {
            
            int elemento = pop();
            temp.push(elemento);

            if(elemento == valor) {
                while(!temp.isEmpty()) {
                    int back = temp.pop();
                    push(back);
                }
                return posRelativa;
            }
            posRelativa++;
        }

        while(!temp.isEmpty()) {
            push(temp.pop);
        }

        return -1;
    }


}
